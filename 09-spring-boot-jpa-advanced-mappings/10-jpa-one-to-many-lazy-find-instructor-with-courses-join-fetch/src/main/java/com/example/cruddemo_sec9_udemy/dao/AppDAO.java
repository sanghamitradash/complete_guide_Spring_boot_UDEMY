package com.example.cruddemo_sec9_udemy.dao;

import com.example.cruddemo_sec9_udemy.entity.Course;
import com.example.cruddemo_sec9_udemy.entity.Instructor;
import com.example.cruddemo_sec9_udemy.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);
}
