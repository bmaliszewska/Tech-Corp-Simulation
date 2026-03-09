package com.example.techcorp;

import java.util.ArrayList;

public class Company {

    String name;
    int budget;

    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Project> projects = new ArrayList<>();

    public Company(String name, int budget) {
        this.name = name;
        this.budget = budget;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void startProject(Project project) {
        projects.add(project);
    }
}