package com.example.lab11springdatajpa;

import com.example.lab11springdatajpa.controller.FactoryControoller;
import com.example.lab11springdatajpa.entities.Departments;
import com.example.lab11springdatajpa.entities.Employees;
import com.example.lab11springdatajpa.entities.Tasks;
import com.example.lab11springdatajpa.repositories.DepartmentRepository;
import com.example.lab11springdatajpa.repositories.EmployeeRepository;
import com.example.lab11springdatajpa.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Lab11SpringDataJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab11SpringDataJpaApplication.class, args);
	}

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	TasksRepository tasksRepository;

	@Override
	public void run(String... args) throws Exception {
		new FactoryControoller(departmentRepository,employeeRepository,tasksRepository).handleFactory();
	}
}
