package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager

    private EntityManager entityManager;

    //inject entityManager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    //implement save method

    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    //STEP-2: Add new method to DAO implementation to read the object
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //STEP-2: create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName", Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student>theQuery = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);

        //set query parameters
        theQuery.setParameter("theData",theLastName);

        //return query results
        return theQuery.getResultList();
    }

    //STEP-2:Add new method to DAO implementation to update the object
    @Override
    @Transactional//used for any modification need to do in database
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    //STEP-2:Add new method to DAO implementation to delete the object
    @Override
    @Transactional//used for any modification need to do in database
    public void delete(Integer id){
        //retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(theStudent);
    }

    //STEP-2:Add new method to DAO implementation to delete all objects from table
    @Override
    @Transactional
    public int deleteAll(){
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        //.executeUpdate means execute this statement where
            //method name "Update" is a generic term we are "modifying" the database
        return numRowsDeleted;
    }
}
