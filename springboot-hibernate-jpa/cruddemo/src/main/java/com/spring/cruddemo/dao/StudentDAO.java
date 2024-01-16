package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findById(int id);

    List<Student> findAll();
    List<Student> findByEmailSpecificity();

    List<Student> findByGivenParamName(String username);

    void updateFirstName(Student student);

    void deleteStudent(int id);

    int deleteAllStudents();
}
