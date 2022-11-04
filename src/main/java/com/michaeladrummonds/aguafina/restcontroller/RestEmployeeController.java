package com.michaeladrummonds.aguafina.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.michaeladrummonds.aguafina.errors.EmployeeNotFoundException;
import com.michaeladrummonds.aguafina.models.Employee;
import com.michaeladrummonds.aguafina.services.impl.EmployeeServiceImpl;

public class RestEmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id) throws EmployeeNotFoundException {

        if (id != 0) {
            return employeeService.getEmployeeById(id);
        } else {
            throw new EmployeeNotFoundException(id);
        }
    }
}
