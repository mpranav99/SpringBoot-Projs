package com.spring.crudrest.service;

import com.spring.crudrest.dao.EmployeeDAO;
import com.spring.crudrest.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO edao){
        this.employeeDAO = edao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public Employee add(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void remove(int id) {
        employeeDAO.deleteEmployee(id);
    }


}
