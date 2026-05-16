package com.example.techcorp;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private double budget;
    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    public Company(String name, double budget) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be empty.");
        }
        if (budget < 0) {
            throw new IllegalArgumentException("Initial budget cannot be negative.");
        }

        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void hire(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }
        employees.add(employee);
    }

    public void startProject(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project cannot be null.");
        }
        projects.add(project);
    }

    public void reduceBudget(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        budget -= amount;
    }

    public void increaseBudget(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        budget += amount;
    }

    public double calculateMonthlySalaries() {
        double total = 0;

        for (Employee employee : employees) {
            total += employee.getSalary();
        }

        return total;
    }

    public void paySalaries() {
        reduceBudget(calculateMonthlySalaries());
    }

    public boolean isBankrupt() {
        return budget < 0;
    }
}