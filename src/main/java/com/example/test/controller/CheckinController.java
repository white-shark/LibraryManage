//package com.example.test.controller;
//
//import com.example.test.dao.CheckinDao;
//import com.example.test.dao.ChecknumDao;
//import com.example.test.entities.Checkin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.Collection;
//
//public class CheckinController {
//
//    @Autowired
//    ChecknumDao checknumDao;
//    @Autowired
//    CheckinDao checkinDao;
//
//    @GetMapping("/checkin")
//    public String toCheckPage(Model model){
//        Collection<Integer> checknum = checknumDao.getAll();
//        Collection<Checkin> checkins = checkinDao.getAll();
//        model.addAttribute("checs",checkins);
//        model.addAttribute("checnums",checknum);
//        System.out.println(checknum);
//
//        return "checkin";
//    }
//
//}
