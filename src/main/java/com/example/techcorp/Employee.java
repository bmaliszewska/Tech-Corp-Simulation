package com.example.techcorp;

public abstract class Employee implements Workable {

    private String name;
    private int skill;
    private double salary;

    public Employee(String name, int skill, double salary) {
        setName(name);
        setSkill(skill);
        setSalary(salary);
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Employee name cannot be empty.");
        }
        this.name = name;
    }

    private void setSkill(int skill) {
        if (skill < 1 || skill > 10) {
            throw new IllegalArgumentException("Skill must be between 1 and 10.");
        }
        this.skill = skill;
    }

    private void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public abstract int work();

    public abstract String getRoleName();

    @Override
    public String toString() {
        return name + " | role: " + getRoleName() + " | skill: " + skill + " | salary: " + salary;
    }
}