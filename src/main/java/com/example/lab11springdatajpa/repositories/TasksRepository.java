package com.example.lab11springdatajpa.repositories;

import com.example.lab11springdatajpa.entities.Employees;
import com.example.lab11springdatajpa.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;
@Component
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
    @Query("SELECT description FROM Tasks description WHERE description.employee.empId = ?1")
    List<Tasks> findByTasksById(int dep_id);
}
