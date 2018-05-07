package com.codeup.habitperformancegame.controllers;

import com.codeup.habitperformancegame.models.Message;
import com.codeup.habitperformancegame.models.User;
import com.codeup.habitperformancegame.repositories.MessageRepository;
import com.codeup.habitperformancegame.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {
    private MessageRepository messageDao;
    private UserRepository userDao;

    public MessageController(MessageRepository messageDao, UserRepository userDao) {
        this.messageDao = messageDao;
        this.userDao = userDao;
    }

    @GetMapping("/messages")
    public String getMessages(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.findOne(user.getId()));
        return "messages/index";
    }

    @GetMapping("/messages/sent")
    public String getSentMessages(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.findOne(user.getId()));
        return "messages/sentMessages";
    }

    @GetMapping("/messages/{id}")
    public String getSingleMessage(Model model, @PathVariable long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.findOne(user.getId()));
        model.addAttribute("single", messageDao.findOne(id));
        return "messages/single";
    }

    @GetMapping("/messages/create")
    public String getMessageForm(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userDao.findOne(user.getId()));
        model.addAttribute("everyone",userDao.findAll());
        model.addAttribute("message", new Message());
        return "messages/create";
    }

    @PostMapping("/messages/create")
    public String postMessageForm(@ModelAttribute Message message , @RequestParam(name = "receivers") List<User> receivers){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User sqlUser = userDao.findOne(user.getId());
        message.setCreated_by(sqlUser);
//        System.out.println(receivers.get(0).getUsername() + ", " + receivers.get(0).getClan().getName());
//        List<User> userObjects = new ArrayList<>();
//        for(int i =0; i < receivers.length; i ++){
//            userObjects.add(userDao.findOne(Long.parseLong(receivers[i])));
//        }
        message.setSent_to(receivers);
        System.out.println("there are this many receivers: " + message.getSent_to().size());
        messageDao.save(message);
        return "redirect:/messages";
    }
}
