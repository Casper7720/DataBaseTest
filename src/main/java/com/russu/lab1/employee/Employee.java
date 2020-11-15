package com.russu.lab1.employee;

import com.russu.lab1.store.Store;

public class Employee {

    protected String name;
    protected Store store;

    protected Employee(String name, Store store){
        this.name = name;
        this.store = store;
    }

    public String getName() {
        return name;
    }
}
