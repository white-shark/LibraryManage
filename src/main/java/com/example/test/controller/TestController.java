package com.example.test.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {
    @RequestMapping({"/","/index.html"})
    public String index(){
        return "login";
    }
}
