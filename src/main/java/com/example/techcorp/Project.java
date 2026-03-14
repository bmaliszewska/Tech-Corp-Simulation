package com.example.techcorp;

import java.util.ArrayList;

public class Project {

    String name;
    int requiredWork;
    int progress = 0;

    ArrayList<Employee> team = new ArrayList<>();

    public Project(String name, int requiredWork) {
        this.name = name;
        this.requiredWork = requiredWork;
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
}

public int turnsNeeded() {
    int totalProductivity = 0;

    for (Employee employee : team) {
        totalProductivity += employee.productivity;
    }

    return (int) Math.ceil((double) requiredWork / totalProductivity);
}
