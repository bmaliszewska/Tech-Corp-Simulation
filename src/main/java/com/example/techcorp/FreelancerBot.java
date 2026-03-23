package com.example.techcorp;

public class FreelancerBot implements Workable {

    private String name;
    private int productivity; 

    public FreelancerBot(String name, int productivity) {
        this.name = name;
        this.productivity = productivity;
    }

    @Override
    public int work() {
        System.out.println(name + " is working automatically for " + productivity + " units.");
        return productivity;
    }

    public String getName() {
        return name;
    }
}