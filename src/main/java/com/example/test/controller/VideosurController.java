package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class VideosurController {

    @GetMapping("videosur")
    public String videosur(HttpSession session) {
        Integer identity = (Integer) session.getAttribute("identity");
        int i = Integer.valueOf(identity);

        if (i == 1) {
            return "videosur";
        } else {
            session.setAttribute("power", 2);
            return "dashboard";
        }
    }
}
