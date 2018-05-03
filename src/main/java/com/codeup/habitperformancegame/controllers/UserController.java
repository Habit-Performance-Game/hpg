package com.codeup.habitperformancegame.controllers;

import com.codeup.habitperformancegame.models.Clan;
import com.codeup.habitperformancegame.repositories.ClanRepository;
import com.codeup.habitperformancegame.repositories.UserRepository;
import com.codeup.habitperformancegame.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userDao;
    private ClanRepository clanDao;
    private PasswordEncoder passwordEncoder;// to be used when implimenting security

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder,ClanRepository clanDao){
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.clanDao = clanDao;
    }

    @GetMapping("/")
    public String showHomePage(){ return "home";}

    //get register page
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    //save user info
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
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
        model.addAttribute("user",userDao.findOne(user.getId()));
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
