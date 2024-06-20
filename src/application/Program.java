package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>(); // Initializing the list with the Employee class

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt(); // Reading list size

        for(int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1));

            System.out.print("Id: ");
            int id = sc.nextInt(); // Reading the id
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine(); // Reading the name
            System.out.print("Salary: ");
            double salary = sc.nextDouble(); // Reading the salary
            list.add(new Employee(id, name, salary));  // Starting an instantiated object and placing it in the list
        }

        System.out.println();

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt(); // Reading the ID of the employee who receives a raise
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if(emp == null) {
            System.out.println("This id does not exist");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }
        System.out.println();
        System.out.println("List of employees: ");
        for(Employee x : list) {
            System.out.println(x);
        }


        sc.close();
    }
}
