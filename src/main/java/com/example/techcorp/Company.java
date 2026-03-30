package com.example.techcorp;

import java.util.ArrayList;

public class Company {

    private String name;
    private int budget;

    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Project> projects = new ArrayList<>();

    public Company(String name, int budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void startProject(Project project) {
        projects.add(project);
    }

    public void printStatus() {
        System.out.println("=== COMPANY STATUS ===");
        System.out.println("Company: " + name);
        System.out.println("Budget: " + budget);

        System.out.println("\nEmployees:");
        for (Employee employee : employees) {
            System.out.println("- " + employee);
        }

        System.out.println("\nProjects:");
        for (Project project : projects) {
            System.out.println("- " + project.getName() + " | progress: "
                    + project.getProgress() + "/" + project.getRequiredWork());

            System.out.println("  Team:");
            for (Workable worker : project.getTeam()) {
                if (worker instanceof Employee employee) {
                    System.out.println("  - " + employee.getName() + " (" + employee.getRoleName() + ")");
                } else {
                    System.out.println("  - " + worker);
                }
            }
        }
    }
}