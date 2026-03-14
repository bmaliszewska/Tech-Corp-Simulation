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

        Project project = new Project("Mobile␣App", 60);

        project.addEmployee(anna);
        project.addEmployee(piotr);
        project.addEmployee(kasia);

        company.startProject(project);

        Project project2 = new Project("Website", 80);

        project2.addEmployee(anna);
        project2.addEmployee(piotr);
        project2.addEmployee(kasia);

        company.startProject(project2);

        project.workOneTurn();
        project2.workOneTurn();
    }
}
