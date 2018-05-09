package com.codeup.habitperformancegame.controllers;

import com.codeup.habitperformancegame.models.Avatar;
import com.codeup.habitperformancegame.models.Clan;
import com.codeup.habitperformancegame.models.User_Badge;
import com.codeup.habitperformancegame.repositories.AvatarRepository;
import com.codeup.habitperformancegame.repositories.ClanRepository;
import com.codeup.habitperformancegame.repositories.UserBadgeRepository;
import com.codeup.habitperformancegame.repositories.UserRepository;
import com.codeup.habitperformancegame.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private AvatarRepository avatarDao;
    private UserRepository userDao;
    private ClanRepository clanDao;
    private UserBadgeRepository userBadgeDao;
    private PasswordEncoder passwordEncoder;// to be used when implementing security

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, ClanRepository clanDao, UserBadgeRepository userBadgeDao, AvatarRepository avatarDao){
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.clanDao = clanDao;
        this.userBadgeDao = userBadgeDao;
        this.avatarDao= avatarDao;
    }

    @GetMapping("/")
    public String showHomePage(Model model){
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            return "home";
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.findOne(user.getId()));
        return "home";}

    //get register page
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("avatars", avatarDao.findAll());
        return "users/register";
    }

    //save user info
    @PostMapping("/register")
    public String saveUser(@Valid User user, Errors validation, Model model){
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "/users/register";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm()  { return "users/login"; }

    @GetMapping("/profile")
    public String showProfilePage(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User sqlUser = userDao.findOne(user.getId());
        model.addAttribute("user",sqlUser);
        model.addAttribute("habits", sqlUser.getUser_badges());
        model.addAttribute("completedHabits", userBadgeDao.findCompleted(sqlUser.getId()));
        model.addAttribute("avatar",avatarDao.findOne(sqlUser.getId()));
        return "users/profile";
    }

    @GetMapping("/clan/{id}")
    public String showClanPage(Model model, @PathVariable long id) {
        System.out.println("before");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.findOne(user.getId()));
        model.addAttribute("clan", clanDao.findOne(id));
        System.out.println("after");
        return "clans/clanProfile";}

}
