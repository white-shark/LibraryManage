package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @GetMapping("/main.html")
    public String toMainPage(HttpSession session){
        session.setAttribute("power",1);
        return "dashboard";
    }
}
