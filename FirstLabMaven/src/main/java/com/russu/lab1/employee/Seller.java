package com.russu.lab1.employee;

import com.russu.lab1.employee.Schedule.Schedule;

public class Seller  extends Employee {

    private final String position = "Seller";
    private int price = 25_000;
    private Schedule scheduleSeller;

    public Seller(String name) {
        super(name);
        scheduleSeller = new Schedule(position);
    }

    public int getPrice() {
        return price;
    }

    public String getPosition() {
        return position;
    }

    public Schedule getScheduleDeputyDirector() {
        return scheduleSeller;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
