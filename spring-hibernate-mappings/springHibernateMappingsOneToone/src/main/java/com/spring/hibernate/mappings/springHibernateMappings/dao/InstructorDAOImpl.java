package com.spring.hibernate.mappings.springHibernateMappings.dao;

import com.spring.hibernate.mappings.springHibernateMappings.entity.Instructor;
import com.spring.hibernate.mappings.springHibernateMappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InstructorDAOImpl implements InstructorDAO{

    private EntityManager em;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager){
        this.em = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        em.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return em.find(Instructor.class, id);
    }

    @Override
    public InstructorDetail findById(int id) {
        return em.find(InstructorDetail.class, id);
    }

//    @Override
//    @Transactional
//    public String removeAll() {
//        Query query = em.createQuery("DELETE from Instructor");
//        int nos  = query.executeUpdate();
//        return nos +" removed all instructors";
//    }

}
