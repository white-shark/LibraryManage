//package com.example.test.time;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.TimeZone;
//
//public class Week {
//
//    public static Date geLastWeekMonday(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(getThisWeekMonday(date));
//        cal.add(Calendar.DATE, -7);
//        return cal.getTime();
//    }
//
//    public static Date getThisWeekMonday(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        // 获得当前日期是一个星期的第几天
//        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
//        if (1 == dayWeek) {
//            cal.add(Calendar.DAY_OF_MONTH, -1);
//        }
//        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
//        cal.setFirstDayOfWeek(Calendar.MONDAY);
//        // 获得当前日期是一个星期的第几天
//        int day = cal.get(Calendar.DAY_OF_WEEK);
//        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
//        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
//        return cal.getTime();
//    }
//
//    public static Date getNextWeekMonday(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(getThisWeekMonday(date));
//        cal.add(Calendar.DATE, 7);
//        return cal.getTime();
//    }
//
//    public static String getthisweek() throws ParseException {
//
//        String monday = null;
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            String today = sdf.format(new Date());
//            Date date = sdf.parse(today);
//            System.out.println("本周一" + sdf.format(getThisWeekMonday(date)));
//            monday = sdf.format(getThisWeekMonday(date));
//            System.out.println(monday);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return monday;
//    }
//
//
//
//    public static Date lastweekget() throws ParseException {
//
//        String monday = null;
//        Date lastmonday;
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//        try{
//            String today = sdf.format(new Date());
//            Date date = sdf.parse(today);
//            System.out.println("上周一" + sdf.format(geLastWeekMonday(date)));
//            System.out.println("本周一" + sdf.format(getThisWeekMonday(date)));
//            monday = sdf.format(geLastWeekMonday(date));
//
//            System.out.println(monday);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        lastmonday = sdf.parse(monday);
//
//        return lastmonday;
//
//
//    }
//
//    public static void main(String[] args) {
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date date = new Date();
//            System.out.println("今天是" + sdf.format(date));
//            System.out.println("上周一" + sdf.format(geLastWeekMonday(date)));
//            System.out.println("本周一" + sdf.format(getThisWeekMonday(date)));
//            System.out.println("下周一" + sdf.format(getNextWeekMonday(date)));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
