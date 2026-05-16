package com.example.techcorp;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private int requiredWork;
    private int progress;
    private List<Workable> team = new ArrayList<>();
    private ProjectStatus status = ProjectStatus.PLANNED;

    public Project(String name, int requiredWork) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Project name cannot be empty.");
        }
        if (requiredWork <= 0) {
            throw new IllegalArgumentException("Required work must be positive.");
        }

        this.name = name;
        this.requiredWork = requiredWork;
        this.progress = 0;
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

    public List<Workable> getTeam() {
        return team;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void addWorker(Workable worker) {
        if (worker == null) {
            throw new IllegalArgumentException("Worker cannot be null.");
        }
        team.add(worker);
    }

    public void start() {
        if (status == ProjectStatus.PLANNED) {
            status = ProjectStatus.IN_PROGRESS;
        }
    }

    public void putOnHold() {
        if (status == ProjectStatus.IN_PROGRESS) {
            status = ProjectStatus.ON_HOLD;
        }
    }

    public void resume() {
        if (status == ProjectStatus.ON_HOLD) {
            status = ProjectStatus.IN_PROGRESS;
        }
    }

    public void workOneTurn() {
        if (status != ProjectStatus.IN_PROGRESS) {
            return;
        }

        for (Workable worker : team) {
            progress += worker.work();
        }

        if (progress >= requiredWork) {
            progress = requiredWork;
            status = ProjectStatus.FINISHED;
        }
    }

    public boolean isFinished() {
        return status == ProjectStatus.FINISHED;
    }

    public int turnsNeeded() {
        int totalProductivity = 0;

        for (Workable worker : team) {
            totalProductivity += worker.work();
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

    public void printProgress() {
        System.out.println(name + ": " + progress + "/" + requiredWork);
    }
}