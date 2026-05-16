package com.example.techcorp;

public class FreelancerBot implements Workable {

    private String name;
    private int productivity;

    public FreelancerBot(String name, int productivity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Bot name cannot be empty.");
        }
        if (productivity <= 0) {
            throw new IllegalArgumentException("Productivity must be positive.");
        }

        this.name = name;
        this.productivity = productivity;
    }

    public String getName() {
        return name;
    }

    @Override
    public int work() {
        return productivity;
    }

    @Override
    public String toString() {
        return name + " | bot productivity: " + productivity;
    }
}