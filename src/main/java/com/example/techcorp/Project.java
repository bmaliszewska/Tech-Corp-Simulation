package com.example.techcorp;

import java.util.ArrayList;

public class Project {

    private String name;
    private int requiredWork;
    private int progress = 0;

    private ArrayList<Employee> team = new ArrayList<>();

    public Project(String name, int requiredWork) {
        this.name = name;
        this.requiredWork = requiredWork;
    }

    public String getName() {
        return name;
    }

    public int getRequiredWork() {
        return requiredWork;
    }

    public int getProgress() {
        return progress;
    }

    public ArrayList<Employee> getTeam() {
        return team;
    }

    public void addEmployee(Employee employee) {
        team.add(employee);
    }

    public void workOneTurn() {
        for (Employee employee : team) {
            progress += employee.work();
        }

        if (progress > requiredWork) {
            progress = requiredWork;
        }
    }

    public boolean isFinished() {
        return progress >= requiredWork;
    }

    public void printProgress() {
        System.out.println(name + ": " + progress + "/" + requiredWork);
    }

    public int turnsNeeded() {
        int totalProductivity = 0;

        for (Employee employee : team) {
            totalProductivity += employee.work();
        }

        if (totalProductivity == 0) {
            return 0;
        }

        int remainingWork = requiredWork - progress;

        if (remainingWork <= 0) {
            return 0;
        }

        return (int) Math.ceil((double) remainingWork / totalProductivity);
    }
}