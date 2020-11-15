package com.russu.lab1.employee;

import com.russu.lab1.employee.Schedule.Schedule;
import com.russu.lab1.store.Store;

public class DeputyDirector extends Employee {

    private final String position = "Deputy Director";
    private int price = 45_000;
    private Schedule scheduleDeputyDirector;

    public DeputyDirector(String name, Store store) {
        super(name, store);
        scheduleDeputyDirector = new Schedule(position);
    }

    public int getPrice() {
        return price;
    }

    public String getPosition() {
        return position;
    }

    public Schedule getScheduleDeputyDirector() {
        return scheduleDeputyDirector;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
