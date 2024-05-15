package com.example.cruddemo_sec9_udemy.dao;

import com.example.cruddemo_sec9_udemy.entity.Instructor;
import com.example.cruddemo_sec9_udemy.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
