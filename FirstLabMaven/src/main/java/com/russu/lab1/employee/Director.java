package com.russu.lab1.employee;

import com.russu.lab1.employee.Schedule.Schedule;

public class Director extends Employee{

    private final String position = "Director";
    private int price = 55_000;
    private Schedule scheduleDirector;

    public Director(String name) {
        super(name);
        scheduleDirector = new Schedule(position);
    }

    public int getPrice() {
        return price;
    }

    public String getPosition() {
        return position;
    }

    public Schedule getScheduleDirector() {
        return scheduleDirector;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
