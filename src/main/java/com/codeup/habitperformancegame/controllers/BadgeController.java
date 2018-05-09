package com.codeup.habitperformancegame.controllers;

import com.codeup.habitperformancegame.models.Badge;
import com.codeup.habitperformancegame.models.Clan_Badge;
import com.codeup.habitperformancegame.models.User;
import com.codeup.habitperformancegame.models.User_Badge;
import com.codeup.habitperformancegame.repositories.BadgeRepository;
import com.codeup.habitperformancegame.repositories.ClanBadgeRepository;
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
    private ClanBadgeRepository clanBadgeDao;

    public BadgeController(BadgeRepository badgeDao, UserRepository userDao, UserBadgeRepository userBadgeDao, ClanBadgeRepository clanBadgeDao) {
        this.badgeDao = badgeDao;
        this.userDao = userDao;
        this.userBadgeDao = userBadgeDao;
        this.clanBadgeDao = clanBadgeDao;
    }

    @GetMapping("/habits")
    public String getHabits(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User mysql = userDao.findOne(user.getId());
        model.addAttribute("user",userDao.findOne(user.getId()));
        model.addAttribute("badges", badgeDao.findNotAdded(user.getId()));
        model.addAttribute("currentBadges", userBadgeDao.findNotCompleted(mysql.getId()));
        model.addAttribute("completedBadges", userBadgeDao.findCompleted(mysql.getId()));
        if (mysql.getClan()!=null) {
            model.addAttribute("clanBadgesNotAdded", badgeDao.clanNotAdded(mysql.getClan().getId()));
            model.addAttribute("clanBadgesAdded", badgeDao.clanAdded(mysql.getClan().getId()));
        }
        return "badges/select";
    }

    @PostMapping("/habits/add")
    public String addHabit(@RequestParam String badge_id, Model model){
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


    @PostMapping("/habits/entry")
    public String addEntry(@RequestParam String userBadgeId, @RequestParam String amount){
        User_Badge habit = userBadgeDao.findOne(Long.parseLong(userBadgeId));
        int previous = habit.getUser_amt();
        int current = Integer.parseInt(amount);
        if(previous+current >= habit.getBadge().getReq_amt()){
            habit.setHas_completed(true);
        }
        habit.setUser_amt(previous + current);
        userBadgeDao.save(habit);
        return "redirect:/profile";
    }

    @PostMapping("/clan/habits/entry")
    public String addClanEntry(@RequestParam String clanBadgeId, @RequestParam String amount, @RequestParam String location){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User mysql = userDao.findOne(user.getId());
        Clan_Badge habit = clanBadgeDao.findOne(Long.parseLong(clanBadgeId));
        int previous = habit.getUser_amt();
        int current = Integer.parseInt(amount);
        if(previous+current >= habit.getBadge().getReq_amt()){
            habit.setHas_completed(true);
        }
        habit.setUser_amt(previous + current);
        clanBadgeDao.save(habit);
        if (location.equals("clan")) {
            return "redirect:/clan/" + mysql.getClan().getId();
        }
        return "redirect:/profile";
    }

    @PostMapping("/habits/remove")
    public String removeHabit(@RequestParam String userBadge_id){
        System.out.println("Delete this: " + userBadge_id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userBadgeDao.delete(Long.parseLong(userBadge_id));
        return "redirect:/habits";
    }

    @PostMapping("/clan/habits/add")
    public String addClanHabit(@RequestParam String badge_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User mysql = userDao.findOne(user.getId());
        Clan_Badge habit = new Clan_Badge();
        habit.setClan(mysql.getClan());
        habit.setUser_amt(0);
        habit.setHas_completed(false);
        habit.setBadge(badgeDao.findOne(Long.parseLong(badge_id)));
        clanBadgeDao.save(habit);
        return "redirect:/habits";
    }

    @PostMapping("/clan/habits/remove")
    public String removeClanHabit(@RequestParam String clanBadge_id){
        clanBadgeDao.delete(Long.parseLong(clanBadge_id));
        return "redirect:/habits";
    }

}
