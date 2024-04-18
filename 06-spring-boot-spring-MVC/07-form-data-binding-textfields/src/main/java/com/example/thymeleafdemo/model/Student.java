package com.example.thymeleafdemo.model;

public class Student {

    private String firstName;
    private String lastName;

    //make a no arg constructor
    public Student(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
