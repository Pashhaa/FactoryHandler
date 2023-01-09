package com.example.lab11springdatajpa.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer empId;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @Column(name = "surname", nullable = false, length = 20)
    private String surname;

    @Column(name = "position", nullable = false, length = 20)
    private String position;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Departments department;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Tasks> tasks;

    public Employees(){}

    public Employees(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "\nEmployee " +
                "empId= " + empId +
                ", name= " + name  +
                ", surname= " + surname  +
                ", position= " + position  +
                ", depId= " + department.getDepId() ;
    }
}
