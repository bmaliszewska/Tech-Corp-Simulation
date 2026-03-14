package com.example.techcorp;

public class Main {

    public static void main(String[]args){

        Company company = new Company("TechCorp", 50000);

        Employee anna = new Employee("Anna", 8, 7000);
        Employee piotr = new Employee("Piotr", 6, 6500);
        Employee kasia = new Employee("Kasia", 2, 3333);

        company.hire(anna);
        company.hire(piotr);
        company.hire(kasia);

        Project project = new Project("Mobile␣App", 30);

        project.addEmployee(anna);
        project.addEmployee(piotr);
        project.addEmployee(kasia);

        company.startProject(project);

        project.workOneTurn();
    }
}
