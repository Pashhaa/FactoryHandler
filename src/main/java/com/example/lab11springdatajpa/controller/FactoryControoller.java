package com.example.lab11springdatajpa.controller;

import com.example.lab11springdatajpa.entities.Employees;
import com.example.lab11springdatajpa.entities.Tasks;
import com.example.lab11springdatajpa.repositories.DepartmentRepository;
import com.example.lab11springdatajpa.repositories.EmployeeRepository;
import com.example.lab11springdatajpa.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

@Controller
public class FactoryControoller {
    final
    DepartmentRepository departmentRepository;

    final
    EmployeeRepository employeeRepository;

    final
    TasksRepository tasksRepository;

    public FactoryControoller(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, TasksRepository tasksRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.tasksRepository = tasksRepository;
    }


    private List<Employees> getEmployees(){return employeeRepository.findAll();}

    private List<Tasks> getTasks(){return tasksRepository.findAll();}

    private void addTask(int empId){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Завдання");
        String descript = scanner.nextLine();
        Tasks task = new Tasks(descript);
        task.setEmployee(employeeRepository.getReferenceById(empId));
        tasksRepository.save(task);
        tasksRepository.findAll();
    }

    private void deleteEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("id: ");
        int emp_id = scanner.nextInt();
        employeeRepository.deleteById(emp_id);
    }

    public void handleFactory(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("\nОтримати список всіх співробітників - el" +
                                "\nOтримати список всіх завдань - tl" +
                                "\nOтримати список співробітників зазначеного відділу - edep" +
                                "\nДодати завдання для деякого співробітника - ae" +
                                "\nДля зазначеного співробітника отримати  список його завдань - etl"+
                                "\nВидалити співробітника - edel" +
                                "\nВийти - q");
            String input = sc.nextLine();
            switch (input){
                case "el" -> System.out.println(getEmployees());
                case "tl" -> System.out.println(getTasks());
                case "edep" -> {
                    System.out.print("id: ");
                    Scanner scanner = new Scanner(System.in);
                    int id = scanner.nextInt();
                    System.out.println(employeeRepository.findByDepId(id));
                }
                case "ae" -> {
                    System.out.print("id: ");
                    Scanner scanner = new Scanner(System.in);
                    int empId = scanner.nextInt();
                    addTask(empId);
                }

                case "etl" ->{
                    System.out.print("id: ");
                    Scanner scanner = new Scanner(System.in);
                    int id = scanner.nextInt();
                    System.out.println(tasksRepository.findByTasksById(id));

                }

                case "edel" -> deleteEmployee();

                case "q" -> flag = false;
                default -> System.out.println("Спробуйте ще раз");
            }

        }
    }
}
