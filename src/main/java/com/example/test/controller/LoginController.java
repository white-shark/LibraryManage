package com.example.test.controller;

import com.example.test.entities.Employee;
import com.example.test.entities.Password;
import com.example.test.repository.EmpRepository;
import com.example.test.repository.PassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;



@Controller
public class LoginController {

    @Autowired
    PassRepository passRepository;
    @Autowired
    EmpRepository empRepository;

    private String username;
    private String password;
    private String name;
    private Employee stuname;
    private Password stu;
    private int identity;

    @PostMapping(value = "user/login")
    public String login(@RequestParam String username,
                        @RequestParam String password, Map<String,Object> map,HttpSession session){

        stuname = empRepository.findByStuID(username);
        name = stuname.getName();
        stu = passRepository.findByStuID(username);
        this.password = stu.getPassword();
        identity = stu.getIdentity();


     //  if(!StringUtils.isEmpty(username))

        if(this.password.equals(password)){
            //登陆成功，防止表单重复提交，重定向到主页
            session.setAttribute("loginUser",username);
            session.setAttribute("stuname",name);
            session.setAttribute("identity",identity);
            session.setAttribute("power",0);
            session.setAttribute("passreset",0);
            return "redirect:/main.html";
        }
        else {
            //登陆失败
            map.put("msg","用户名密码错误");
            return "login";

        }

    }


}
