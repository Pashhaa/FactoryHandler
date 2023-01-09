package com.example.lab11springdatajpa.repositories;

import com.example.lab11springdatajpa.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Integer> {
    @Query("SELECT name FROM Employees name WHERE name.department.depId = ?1")
    List<Employees> findByDepId(int dep_id);



}
