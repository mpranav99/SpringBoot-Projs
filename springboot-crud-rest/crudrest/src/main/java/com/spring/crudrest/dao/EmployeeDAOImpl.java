package com.spring.crudrest.dao;

import com.spring.crudrest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.em = entityManager;
    }
    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = em.createQuery("From Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(int id) {
        TypedQuery<Employee> query= em.createQuery("From Employee where id = :data", Employee.class);
        query.setParameter("data" , id);
        return query.getSingleResult();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee theEmployee =  em.merge(employee);
        return theEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        Employee emp = em.find(Employee.class, id);
        em.remove(emp);
    }
}
