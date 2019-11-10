package com.javalec.spring.TheHuddleSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TemplateController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/main")
    public String getMain() {
        return "main";
    }
}
