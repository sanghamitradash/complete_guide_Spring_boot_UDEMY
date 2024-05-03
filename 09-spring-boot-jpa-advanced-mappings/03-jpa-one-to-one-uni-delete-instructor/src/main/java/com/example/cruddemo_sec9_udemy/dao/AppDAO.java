package com.example.cruddemo_sec9_udemy.dao;

import com.example.cruddemo_sec9_udemy.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
