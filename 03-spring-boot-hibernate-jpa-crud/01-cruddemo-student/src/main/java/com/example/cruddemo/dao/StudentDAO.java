package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    //STEP-1: Add new method to DAO Interface to read the object
    Student findById(Integer id);

    //STEP-1: Add new method to DAO interface for querying objects
    List<Student> findAll();

    List<Student>findByLastName(String theLastName);

    //STEP-1: update the objects
    void update(Student theStudent);

    //STEP-1: delete the objects
    void delete(Integer id);

    //STEP-1: delete all from table
    int deleteAll();

}
