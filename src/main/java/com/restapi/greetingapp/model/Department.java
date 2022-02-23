package com.restapi.greetingapp.model;

public class Department {
    private Long Id;

    private String name;

    private String location;
    public Department() {
        Id = -1L;
        this.name = "";
        this.location = "";
    }
    public Department(Long id, String name, String location) {
        Id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
