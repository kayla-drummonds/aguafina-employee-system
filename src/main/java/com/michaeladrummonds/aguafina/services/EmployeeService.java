package com.michaeladrummonds.aguafina.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.michaeladrummonds.aguafina.models.Employee;

@Component
public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee updateEmplyee(Employee employee);

    Employee getEmployeeById(Integer id);

    Employee getEmployeeByEmail(String email);

    void deleteEmployeeById(Integer id);
}
