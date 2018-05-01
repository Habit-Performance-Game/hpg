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

@Controller
public class ClanController {

    private ClanRepository clanDao;

    public ClanController(ClanRepository clanDao) {
        this.clanDao = clanDao;
    }

    @GetMapping("/clan/create")
    public String createClanForm(Model model){
        model.addAttribute("clan",new Clan());
        return "clans/create";
    }

    @PostMapping("/clan/create")
    public String createClanSubmit(@ModelAttribute Clan clan){
//        User curUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        clan.setOwner_id(curUser.getId());
        clanDao.save(clan);
        return "redirect:/";
    }
}
