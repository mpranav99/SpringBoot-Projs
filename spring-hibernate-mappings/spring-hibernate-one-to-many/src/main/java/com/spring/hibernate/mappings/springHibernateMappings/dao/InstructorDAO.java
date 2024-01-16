package com.spring.hibernate.mappings.springHibernateMappings.dao;

import com.spring.hibernate.mappings.springHibernateMappings.entity.Course;
import com.spring.hibernate.mappings.springHibernateMappings.entity.Instructor;
import com.spring.hibernate.mappings.springHibernateMappings.entity.InstructorDetail;

import java.util.List;

public interface InstructorDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

//    String removeAll();

    InstructorDetail findById(int id);

    List<Course> findCoursesByInstructorId(int id);

    //this method will retrieve both instructor and related courses through a join
    //fetch query in jpql
    Instructor findInstructorAndRelatedCourses(int id);

    void update(Instructor instructor);
}
