package com.spring.hibernate.mappings.springHibernateMappings.dao;

import com.spring.hibernate.mappings.springHibernateMappings.entity.Course;
import com.spring.hibernate.mappings.springHibernateMappings.entity.Instructor;
import com.spring.hibernate.mappings.springHibernateMappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //this will create a new session for course table and will fetch course and enable lazy loading
    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = em.createQuery("From Course where instructor.id=:theData", Course.class);
        query.setParameter("theData", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorAndRelatedCourses(int id) {
        TypedQuery<Instructor> query = em.createQuery("select i from Instructor i " + "JOIN fetch i.courses " + "where i.id=:theData", Instructor.class);
        query.setParameter("theData" , id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        em.merge(instructor);
    }

//    @Override
//    @Transactional
//    public String removeAll() {
//        Query query = em.createQuery("DELETE from Instructor");
//        int nos  = query.executeUpdate();
//        return nos +" removed all instructors";
//    }

}
