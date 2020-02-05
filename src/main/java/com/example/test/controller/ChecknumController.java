package com.example.test.controller;

import com.example.test.dao.ChecknumDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ChecknumController {

    @Autowired
    ChecknumDao checknumDao;


    @PostMapping("/getchecknum")
    public String getChecknum() throws ParseException {
        List<Integer>list = new ArrayList<>();
        list = checknumDao.setChecknum();
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("date",list);
        String date;
        date = jsonObject.toString();
        checknumDao.clearChecknum();
        list.clear();
        return date;
    }

}
