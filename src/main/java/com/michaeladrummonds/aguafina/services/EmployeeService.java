package com.aguafina.springboot.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aguafina.springboot.models.Employee;

@Component
public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);
}
