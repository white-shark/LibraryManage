package com.example.test.controller;


import com.example.test.dao.CheckinDao;
import com.example.test.entities.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.util.Collection;


@Controller
public class ReportsController {

    @Autowired
    CheckinDao checkinDao;


    //查询出勤信息
    @GetMapping("/reports")
    public String list(Model model) throws ParseException {

        checkinDao.setCheckins();
        Collection<Checkin> checkins = checkinDao.getAll();

        //放在请求域中
        model.addAttribute("checs",checkins);

        return "reports";
    }
}
