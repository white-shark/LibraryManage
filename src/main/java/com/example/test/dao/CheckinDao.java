package com.example.test.dao;

import com.example.test.entities.Checkin;
import com.example.test.entities.Employee;
import com.example.test.repository.CheckRepository;
import com.example.test.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
@RestController
public class CheckinDao {
    @Autowired
    CheckRepository checkRepository;

    HashMap <Integer,Checkin> checkins = new HashMap<>();

    public void setCheckins(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        List<Checkin> list = checkRepository.findAll();
        int i=0;
        Checkin checkin = null;
        for (i=0;i<list.size();i++){
            checkin = list.get(i);
            if (checkin.getCheckdate().equals(today)) {
                checkins.put(checkin.getId(), checkin);
            }

        }
    }
    public Collection<Checkin> getAll(){

        return checkins.values();
    }

    public Checkin get(Integer id){
        return checkins.get(id);
    }

    public void delete(Integer id){
        checkins.remove(id);
    }
}
