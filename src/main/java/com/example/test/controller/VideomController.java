package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class VideomController {
    @GetMapping("/videom")
    public String videom(Model model,HttpSession session){
        Integer identity = (Integer) session.getAttribute("identity");
        int i = Integer.valueOf(identity);

        if (i==1){
            return "videomanagement";
        }
        else {
            session.setAttribute("power",2);
            model.addAttribute("power",2);
            return "dashboard";
        }


    }
}
