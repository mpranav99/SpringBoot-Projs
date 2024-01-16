package com.spring.hibernate.mappings.springHibernateMappings.dao;

import com.spring.hibernate.mappings.springHibernateMappings.entity.Instructor;
import com.spring.hibernate.mappings.springHibernateMappings.entity.InstructorDetail;

public interface InstructorDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

//    String removeAll();

    InstructorDetail findById(int id);

}
