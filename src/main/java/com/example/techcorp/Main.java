package com.example.techcorp;

public class Main {

    public static void main(String[] args) {

        Company company = new Company("TechCorp", 50000);

        Employee anna = new Developer("Anna", 8, 7000);
        Employee piotr = new Tester("Piotr", 6, 6500);
        Employee kasia = new Manager("Kasia", 7, 9000);
        Employee ola = new Intern("Ola", 4, 2000);

        company.hire(anna);
        company.hire(piotr);
        company.hire(kasia);
        company.hire(ola);

        Project mobileApp = new Project("Mobile App", 60);
        mobileApp.addWorker(anna);
        mobileApp.addWorker(piotr);

        Project website = new Project("Website", 50);
        website.addWorker(kasia);
        website.addWorker(ola);

        Project automation = new Project("AI Automation", 80);
        automation.addWorker(anna);
        automation.addWorker(new FreelancerBot("AutoWorker", 5));

        company.startProject(mobileApp);
        company.startProject(website);
        company.startProject(automation);

        ConsoleUI ui = new ConsoleUI();
        GameEngine engine = new GameEngine(company, ui);

        engine.start();
    }
}