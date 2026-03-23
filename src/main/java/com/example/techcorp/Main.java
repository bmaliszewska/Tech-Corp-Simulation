package com.example.techcorp;

public class Main {

    public static double getSalary(Employee employee) {
        return employee.getSalary();
    }

    public static int addSkills(Employee first, Employee second) {
        return first.getSkill() + second.getSkill();
    }

    public static void printProjectStatus(Project project) {
        System.out.println("Project status -> " + project.getName() + ": "
                + project.getProgress() + "/" + project.getRequiredWork());
    }

    public static void main(String[] args) {
        String companyName = "TechCorp";
        double cash = 50000;
        int employeesCount = 4;
        boolean projectFinished = false;

        System.out.println(companyName);
        System.out.println(cash);
        System.out.println(employeesCount);
        System.out.println(projectFinished);

        Company company = new Company("TechCorp", 50000);

        Employee anna = new Developer("Anna", 8, 7000);
        Employee piotr = new Tester("Piotr", 6, 6500);
        Employee kasia = new Manager("Kasia", 2, 3333);
        Employee ola = new Intern("Ola", 4, 2000);

        company.hire(anna);
        company.hire(piotr);
        company.hire(kasia);
        company.hire(ola);

        System.out.println("\nSalary of Anna: " + getSalary(anna));
        System.out.println("Anna + Piotr skills: " + addSkills(anna, piotr));

        // === Project 1 & 2 ===
        Project project1 = new Project("Mobile App", 60);
        Project project2 = new Project("Website", 60);

        project1.addWorker(anna);
        project1.addWorker(piotr);

        project2.addWorker(kasia);
        project2.addWorker(ola);

        company.startProject(project1);
        company.startProject(project2);

        company.printStatus();

        int totalWork = anna.work() + piotr.work();
        System.out.println("\nTotal work of Anna and Piotr: " + totalWork);

        System.out.println("\nTurns needed for Mobile App: " + project1.turnsNeeded());
        System.out.println("Turns needed for Website: " + project2.turnsNeeded());

        if (project1.turnsNeeded() < project2.turnsNeeded()) {
            System.out.println("Mobile App should finish first.");
        } else if (project2.turnsNeeded() < project1.turnsNeeded()) {
            System.out.println("Website should finish first.");
        } else {
            System.out.println("Both projects should finish in the same number of turns.");
        }

        int turn = 1;
        while (!project1.isFinished() || !project2.isFinished()) {
            System.out.println("\n=== TURN " + turn + " ===");

            if (!project1.isFinished()) {
                project1.workOneTurn();
            }

            if (!project2.isFinished()) {
                project2.workOneTurn();
            }

            printProjectStatus(project1);
            printProjectStatus(project2);

            turn++;
        }

        System.out.println(project1.getName() + " finished: " + project1.isFinished());
        System.out.println(project2.getName() + " finished: " + project2.isFinished());

        // === Project 3 ===
        Project project3 = new Project("CRM System", 100);
        project3.addWorker(anna);
        project3.addWorker(piotr);
        project3.addWorker(kasia);
        project3.addWorker(ola);

        int turns = 0;
        while (!project3.isFinished()) {
            project3.workOneTurn();
            turns++;
        }

        System.out.println("\nCRM System finished in " + turns + " turns.");
        printProjectStatus(project3);

        // === Project 4 (Mixed Team) ===
        Project project4 = new Project("AI Automation", 80);

        project4.addWorker(anna);
        project4.addWorker(piotr);

        FreelancerBot bot = new FreelancerBot("AutoWorker", 5);
        project4.addWorker(bot);

        project4.start();

        int turnMixed = 1;
        while (!project4.isFinished()) {
            System.out.println("\n=== TURN " + turnMixed + " ===");
            project4.workOneTurn();
            project4.printProgress();
            turnMixed++;
        }

        System.out.println(project4.getName() + " finished in " + (turnMixed-1) + " turns.");
    }
}