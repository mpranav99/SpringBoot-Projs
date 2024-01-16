package com.spring.crudrest.service;

//import com.spring.crudrest.dao.EmployeeDAO;
import com.spring.crudrest.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);

    Employee add(Employee employee);

    void remove(int id);

}
