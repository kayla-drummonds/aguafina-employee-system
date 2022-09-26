package com.aguafina.springboot.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aguafina.springboot.models.Employee;
import com.aguafina.springboot.repository.EmployeeRepository;
import com.aguafina.springboot.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
