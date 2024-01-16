package com.spring.crudrest.controller;

import com.spring.crudrest.dao.EmployeeDAO;
import com.spring.crudrest.entity.Employee;
import com.spring.crudrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService service;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.service = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return service.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee emp = service.findById(id);
        if(emp == null ) throw new RuntimeException("Employee Not Found!! - " + id);
        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return service.add(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        Employee employee = service.add(emp);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public void removeEmployee(@PathVariable("id") int empID){
        service.remove(empID);
    }

}
