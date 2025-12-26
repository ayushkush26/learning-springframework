package com.cdac;

public class Student {
    int id;
    String name;

    public void display() {
        System.out.println(id + " " + name);
    }

    // setters (REQUIRED for DI)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
