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

    public enum ProjectStatus {
        PLANNED,
        IN_PROGRESS,
        ON_HOLD,
        FINISHED,
        CANCELLED
    }

    private ProjectStatus status = ProjectStatus.PLANNED;

    public void start() {
        if (status == ProjectStatus.PLANNED) {
            status = ProjectStatus.IN_PROGRESS;
            System.out.println("Project started");
        }
    }

    public void putOnHold() {
        if (status == ProjectStatus.IN_PROGRESS) {
         status = ProjectStatus.ON_HOLD;
            System.out.println("Project is now ON HOLD");
        }
    }

    public void resume() {
        if (status == ProjectStatus.ON_HOLD) {
          status = ProjectStatus.IN_PROGRESS;
         System.out.println("Project resumed (IN PROGRESS)");
        }
    }

    public void workOneTurn() {
        if (status == ProjectStatus.PLANNED ||
            status == ProjectStatus.ON_HOLD ||
            status == ProjectStatus.CANCELLED ||
            status == ProjectStatus.FINISHED) {
            return;
        }

        for (Employee employee : team) {
            progress += employee.work();
            }

        if (progress >= requiredWork) {
            progress = requiredWork;
            status = ProjectStatus.FINISHED;
            System.out.println("Project finished!");
        }
    }

}