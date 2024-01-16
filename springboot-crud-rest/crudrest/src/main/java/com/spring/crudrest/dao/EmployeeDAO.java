package com.spring.crudrest.dao;

import com.spring.crudrest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee);

    void deleteEmployee(int id);


}
