package com.russu.lab1.employee.Schedule;

public class Schedule {
    private String monday = "Chill";
    private String tuesday= "Chill";
    private String wednesday= "Chill";
    private String thursday= "Chill";
    private String friday= "Chill";
    private String saturday= "Chill";
    private String sunday= "Chill";

    public Schedule(String position){
        switch (position){
            case "Director":
                monday = "11:00 - 21:00";
                tuesday= "11:00 - 21:00";
                wednesday= "11:00 - 21:00";
                thursday= "11:00 - 21:00";
                friday= "11:00 - 21:00";
                saturday= "Chill";
                sunday= "Chill";
                break;
            case "Deputy Director":
                monday = "8:00 - 22:00";
                tuesday = "8:00 - 22:00";
                wednesday = "8:00 - 22:00";
                thursday = "8:00 - 22:00";
                friday = "8:00 - 22:00";
                saturday = "10:00 - 18:00";
                sunday = "10:00 - 18:00";
                break;
            case "Seller":
                monday = "8:30 - 22:00";
                tuesday = "8:30 - 22:00";
                wednesday = "8:30 - 22:00";
                thursday = "8:30 - 22:00";
                friday = "8:30 - 22:00";
                saturday = "8:30 - 18:00";
                sunday = "8:30 - 18:00";
                break;
        }

    }
}
