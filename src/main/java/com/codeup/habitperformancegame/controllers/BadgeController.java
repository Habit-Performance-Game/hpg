package com.codeup.habitperformancegame.controllers;

import com.codeup.habitperformancegame.models.User;
import com.codeup.habitperformancegame.repositories.BadgeRepository;
import com.codeup.habitperformancegame.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BadgeController {

    private UserRepository userDao;
    private BadgeRepository badgeDao;

    public BadgeController(BadgeRepository badgeDao, UserRepository userDao) {
        this.badgeDao = badgeDao;
        this.userDao = userDao;
    }

    @GetMapping("/habits")
    public String getHabits(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.findOne(user.getId()));
        model.addAttribute("badge", badgeDao.findAll());
        return "badges/select";
    }

}
