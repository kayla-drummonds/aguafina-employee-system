package com.michaeladrummonds.aguafina.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.michaeladrummonds.aguafina.models.Employee;
import com.michaeladrummonds.aguafina.repository.EmployeeRepository;

public class RestEmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id, Employee employee) {
        return employeeRepository.findById(employee, id);
    }
}
