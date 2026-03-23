package com.example.techcorp;

public abstract class Employee implements Workable {

    private String name;
    private int skill;
    private double salary;

    public Employee(String name, int skill, double salary) {
        this.name = name;
        setSkill(skill);
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

    public void setSkill(int skill) {
        if (skill >= 1 && skill <= 10) {
            this.skill = skill;
        } else {
            this.skill = 1;
        }
    }

    @Override
    public abstract int work();

    public abstract String getRoleName();

    @Override
    public String toString() {
        return name + " | role: " + getRoleName() + " | skill: " + skill + " | salary: " + salary;
    }
}