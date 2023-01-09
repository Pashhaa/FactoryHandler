package com.example.lab11springdatajpa.repositories;

import com.example.lab11springdatajpa.entities.Departments;
import jakarta.persistence.Column;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Integer> {
}
