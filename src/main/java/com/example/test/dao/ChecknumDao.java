package com.example.test.dao;

import com.example.test.entities.Checkin;
import com.example.test.repository.CheckRepository;
import com.example.test.time.WeekDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.*;

@Repository
public class ChecknumDao {


    @Autowired
    CheckRepository checkRepository;

    private List<Integer> checknum = new ArrayList<>();

    public List<Integer> setChecknum() throws ParseException {


        int i = 0;
        int j = 0;
        int num = 0;
        String day;
        List<String> weekday = WeekDay.setweekday();
        List<Checkin> list = new ArrayList<>();
        List<Checkin> sumnum = new ArrayList<>();
        list = checkRepository.findAll();
//        weekday = WeekDay.setweekday();
        for (i=0;i<weekday.size();i++)
        {
            day = weekday.get(i);
            for (j=0;j<list.size();j++){
                if (list.get(j).getCheckdate().equals(day)){
                    sumnum.add(list.get(j));
                }
        }
            num = sumnum.size();
            sumnum.clear();
            checknum.add(num);
        }
        list.clear();
        weekday.clear();
        sumnum.clear();
       return checknum;
    }

    public void clearChecknum() {
        checknum.clear();
    }

//    public Collection<Integer> getAll() {
//        return checknum.values();
//    }

}
