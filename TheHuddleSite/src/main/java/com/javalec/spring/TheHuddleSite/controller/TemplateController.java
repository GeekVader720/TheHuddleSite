package com.javalec.spring.TheHuddleSite.controller;

import com.javalec.spring.TheHuddleSite.model.User;
import com.javalec.spring.TheHuddleSite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class TemplateController {


    private UserRepository userRepository;

    @Autowired
    public TemplateController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping
    public String getRoot() {
        return "login";
    }

    @GetMapping("/main")
    public String getMain() { return "main"; }

    @GetMapping("/chatroom")
    public String getChat() { return "chatroom"; }

    @GetMapping("/signup")
    public String getSignup() { return "signup"; }

    @PostMapping(value = "/signup")
    public RedirectView postSignup(@ModelAttribute User user) {
        userRepository.save(user);
        return new RedirectView("login");
    }

    @PostMapping(value = "/login")
    public RedirectView postLogin(@RequestBody Map<String, Object> body) {
        return new RedirectView("login");
    }

    @GetMapping("/user")
    public @ResponseBody User getUser() {
        return userRepository.findAll().get(0);
    }
}
