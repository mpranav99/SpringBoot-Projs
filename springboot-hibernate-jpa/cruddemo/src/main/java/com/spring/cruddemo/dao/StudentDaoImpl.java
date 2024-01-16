package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO{

//    @Autowired
    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager em){
        this.entityManager = em;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    //no need to use @Transactional annotation as we are not updating any data but simply reading from DB
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student" , Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByEmailSpecificity() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student where email LIKE '%544@gmail.com'",Student.class);
        return theQuery.getResultList();
    }

    //for queries with named params we use the :thedata to read the user param while
    //entering the query and retrieving values respectively
    @Override
    public List<Student> findByGivenParamName(String username) {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student where firstName=:theData",Student.class);
        theQuery.setParameter("theData", username);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateFirstName(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student studentToBeDeleted = entityManager.find(Student.class, id);
        entityManager.remove(studentToBeDeleted);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        return entityManager.createQuery("DELETE From Student").executeUpdate();


    }


}
