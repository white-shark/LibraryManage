package com.example.test.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class WeekDay {
//    @Autowired
//    ThisMonday thisMonday;

    static List<String> weekday = new ArrayList<>();
    public static List<String>  setweekday() throws ParseException {
        ThisMonday thisMonday = new ThisMonday();

        Date monday = thisMonday.getthisweek();
        GregorianCalendar gc=new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        gc.setTime(monday);
        int i = 0;
        for (i=0;i<7;i++)
        {
            weekday.add(sdf.format(gc.getTime()));
            gc.add(5,1);
        }
        return weekday;
    }

    public void clearweekday(){
        weekday.clear();
    }

//    public static void main(String args[]) throws ParseException {
//        ThisMonday thisMonday = new ThisMonday();
//        Date monday = thisMonday.getthisweek();
//        GregorianCalendar gc=new GregorianCalendar();
//        gc.setTime(monday);
//        gc.add(5,1);
//        Date date = gc.getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String s = sdf.format(date);
//        System.out.println(s);
//    }
}
