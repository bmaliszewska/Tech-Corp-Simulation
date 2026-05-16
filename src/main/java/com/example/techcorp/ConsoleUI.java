package com.example.techcorp;

import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);

    public void showTurnHeader(int turn) {
        System.out.println();
        System.out.println("=== TURN " + turn + " ===");
    }

    public void showMainMenu() {
        System.out.println();
        System.out.println("Choose an action:");
        System.out.println("1. Show company status");
        System.out.println("2. Start planned projects");
        System.out.println("3. Work on projects");
        System.out.println("4. Pay salaries");
        System.out.println("5. Apply random event");
        System.out.println("0. Exit game");
    }

    public int readMenuChoice() {
        System.out.print("Enter choice: ");

        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            return -1;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    public void showCompanyStatus(Company company) {
        System.out.println();
        System.out.println("=== COMPANY STATUS ===");
        System.out.println("Company: " + company.getName());
        System.out.println("Budget: " + company.getBudget());

        System.out.println();
        System.out.println("Employees:");
        for (Employee employee : company.getEmployees()) {
            System.out.println("- " + employee);
        }

        System.out.println();
        System.out.println("Projects:");
        for (Project project : company.getProjects()) {
            System.out.println("- " + project.getName()
                    + " | status: " + project.getStatus()
                    + " | progress: " + project.getProgress()
                    + "/" + project.getRequiredWork());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}