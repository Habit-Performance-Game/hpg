package com.codeup.habitperformancegame.controllers;

import com.codeup.habitperformancegame.UserRepository;
import com.codeup.habitperformancegame.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;// to be used when implimenting security

    public UserController(UserRepository userDao){
        this.userDao = userDao;

    }

    //get register page
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    //save user info
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String password = user.getPassword();
        user.setPassword(password);
        userDao.save(user);
        return "redirect:/login";
    }




}
