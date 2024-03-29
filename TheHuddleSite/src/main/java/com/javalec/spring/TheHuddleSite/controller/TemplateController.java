package com.javalec.spring.TheHuddleSite.controller;

import com.javalec.spring.TheHuddleSite.model.MyUserPrincipal;
import com.javalec.spring.TheHuddleSite.model.User;
import com.javalec.spring.TheHuddleSite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TemplateController {


    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TemplateController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/login")
    public String getLogin(MyUserPrincipal userPrincipal) {
        if (userPrincipal.getUser() != null) {
            return "redirect:/main";
        }
        return "login";
    }

    @GetMapping
    public String getRoot() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String getMain() {
        return "main";
    }

    @GetMapping("/chatroom")
    public String getChat() {
        return "chatroom";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "signup";
    }

    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }

    @GetMapping("/update")
    public String getUpdate() {
        return "update";
    }

    @PostMapping(value = "/signup")
    public RedirectView postSignup(@ModelAttribute User user) {
        String hashBeast = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashBeast);
        userRepository.save(user);
        return new RedirectView("login");
    }

    @PostMapping(value = "/update")
    public RedirectView postUpdate(@ModelAttribute User user) {
        String hashBeast = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashBeast);
        userRepository.save(user);
        return new RedirectView("profile");
    }
    @GetMapping("/user")
    public @ResponseBody
    User getUser() {
        return userRepository.findAll().get(0);
    }
}