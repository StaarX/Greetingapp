package com.restapi.greetingapp.model;

public class Employee {
    private Long id;
    private String name;
    private Double salary;
    private String email;

    public Employee() {
        this.id = -1L;
        this.name = "";
        this.salary = -1D;
        this.email = "";
    }


    public Employee(Long id, String name, Double salary, String email) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
