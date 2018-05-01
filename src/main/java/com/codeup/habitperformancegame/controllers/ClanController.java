package com.codeup.habitperformancegame.controllers;

import com.codeup.habitperformancegame.models.Clan;
import com.codeup.habitperformancegame.models.User;
import com.codeup.habitperformancegame.repositories.ClanRepository;
import com.codeup.habitperformancegame.repositories.UserRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClanController {

    private ClanRepository clanDao;
    private UserRepository userDao;

    public ClanController(ClanRepository clanDao, UserRepository userDao) {
        this.clanDao = clanDao;
        this.userDao = userDao;
    }

    @GetMapping("/clan/create")
    public String createClanForm(Model model){
        model.addAttribute("clan",new Clan());
        return "clans/create";
    }

    @PostMapping("/clan/create")
    public String createClanSubmit(@ModelAttribute Clan clan){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        clan.setOwner_id(user.getId());
        clanDao.save(clan);
        return "users/profile";
    }

    @GetMapping("/clan/join")
    public String joinAClan(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.findOne(user.getId()));
        model.addAttribute("clans", clanDao.findAll());
        return "clans/join";
    }
    @PostMapping("/clan/join")
    public String joinClan(@RequestParam String clan){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User sqlUser = userDao.findOne(user.getId());
        sqlUser.setClan(clanDao.findOne(Long.parseLong(clan)));
        userDao.save(sqlUser);
        return "users/profile";
    }
}
