package com.example.lab11springdatajpa.entities;

import jakarta.persistence.*;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer taskId;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employees employee;

    public Tasks(){}

    public Tasks(String description) {
        this.description = description;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "\nTask " +
                "taskId= " + taskId +
                ", description= " + description +
                ", employee id= " + employee.getEmpId() ;
    }
}
