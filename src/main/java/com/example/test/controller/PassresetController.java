package com.example.test.controller;

import com.example.test.entities.Passreset;
import com.example.test.entities.Password;
import com.example.test.repository.PassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PassresetController {

    @Autowired
    PassRepository passRepository;


    @GetMapping("/passreset")
    public String toPassresetPage(){
        return "passreset";
    }
    @PostMapping("/passreset")
    public String passreset(Passreset passreset, HttpSession session){
        String newpass;
        String confirmpass;
        String username = (String) session.getAttribute("loginUser");
        Password password = passRepository.findByStuID(username);
        newpass = passreset.getNewpass();
        confirmpass = passreset.getConfirmpass();
        if (password.getPassword().equals(passreset.getOldpass())){
            if (newpass.equals(confirmpass)){
                password.setPassword(newpass);
                passRepository.save(password);
                session.setAttribute("passreset",0);
                return "redirect:/emps";
            }
            else {
              session.setAttribute("passreset",1);
              return "passreset";
            }

        }
        else {
            session.setAttribute("passreset",2);
            return "passreset";
        }


    }
}
