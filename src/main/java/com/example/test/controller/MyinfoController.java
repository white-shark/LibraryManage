package com.example.test.controller;

import com.example.test.entities.Employee;
import com.example.test.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MyinfoController {

    @Autowired
    EmpRepository empRepository;

    @GetMapping("/myinfo")
    public String toMyinfoPage(HttpSession session, Model model){
        String username = (String) session.getAttribute("loginUser");
        Employee employee = empRepository.findByStuID(username);
        model.addAttribute("info",employee);
        return "myinfo";
    }

    //修改信息
    @PutMapping("/myinfo")
    public String editEmployee(Employee employee){
        empRepository.save(employee);
        return "redirect:/emps";
    }
}
