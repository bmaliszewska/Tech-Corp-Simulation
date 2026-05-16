package com.example.techcorp;

import java.util.Random;

public class GameEngine {

    private Company company;
    private ConsoleUI ui;
    private boolean running;
    private int turn;
    private Random random = new Random();

    public GameEngine(Company company, ConsoleUI ui) {
        this.company = company;
        this.ui = ui;
        this.running = true;
        this.turn = 1;
    }

    public void start() {
        while (running) {
            ui.showTurnHeader(turn);
            ui.showCompanyStatus(company);
            ui.showMainMenu();

            int choice = ui.readMenuChoice();
            handleChoice(choice);

            if (running) {
                checkEndConditions();
                turn++;
            }
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1 -> ui.showCompanyStatus(company);
            case 2 -> startPlannedProjects();
            case 3 -> workOnProjects();
            case 4 -> paySalaries();
            case 5 -> applyRandomEvent();
            case 0 -> running = false;
            default -> ui.showMessage("Invalid menu option.");
        }
    }

    private void startPlannedProjects() {
        for (Project project : company.getProjects()) {
            if (project.getStatus() == ProjectStatus.PLANNED) {
                project.start();
            }
        }

        ui.showMessage("All planned projects have been started.");
    }

    private void workOnProjects() {
        for (Project project : company.getProjects()) {
            project.workOneTurn();
        }

        ui.showMessage("Projects worked for one turn.");
    }

    private void paySalaries() {
        double salaries = company.calculateMonthlySalaries();
        company.paySalaries();

        ui.showMessage("Paid salaries: " + salaries);
    }

    private void applyRandomEvent() {
        GameEvent event;

        if (random.nextBoolean()) {
            event = new MarketSlowdownEvent();
        } else {
            event = new InvestorBonusEvent();
        }

        event.apply(company);
        ui.showMessage(event.getDescription());
    }

    private void checkEndConditions() {
        if (company.isBankrupt()) {
            ui.showMessage("Company is bankrupt. Game over.");
            running = false;
            return;
        }

        if (allProjectsFinished()) {
            ui.showMessage("All projects are finished. You win!");
            running = false;
        }
    }

    private boolean allProjectsFinished() {
        if (company.getProjects().isEmpty()) {
            return false;
        }

        for (Project project : company.getProjects()) {
            if (!project.isFinished()) {
                return false;
            }
        }

        return true;
    }
}