package com.codeup.habitperformancegame.controllers;

import com.codeup.habitperformancegame.models.Badge;
import com.codeup.habitperformancegame.models.User;
import com.codeup.habitperformancegame.models.User_Badge;
import com.codeup.habitperformancegame.repositories.BadgeRepository;
import com.codeup.habitperformancegame.repositories.UserBadgeRepository;
import com.codeup.habitperformancegame.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BadgeController {

    private UserRepository userDao;
    private BadgeRepository badgeDao;
    private UserBadgeRepository userBadgeDao;

    public BadgeController(BadgeRepository badgeDao, UserRepository userDao, UserBadgeRepository userBadgeDao) {
        this.badgeDao = badgeDao;
        this.userDao = userDao;
        this.userBadgeDao = userBadgeDao;
    }

    @GetMapping("/habits")
    public String getHabits(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.findOne(user.getId()));
        model.addAttribute("badges", badgeDao.findAll());
        return "badges/select";
    }

    @PostMapping("/habits")
    public String addHabit(@RequestParam String badge_id, Model model){
        System.out.println("the ID is " + badge_id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User mysql = userDao.findOne(user.getId());
        User_Badge habit = new User_Badge();
        habit.setUser(mysql);
        habit.setUser_amt(0);
        habit.setHas_completed(false);
        habit.setBadge(badgeDao.findOne(Long.parseLong(badge_id)));
        System.out.println(habit.getBadge().getName());
        userBadgeDao.save(habit);
        return "redirect:/habits";
    }

}
