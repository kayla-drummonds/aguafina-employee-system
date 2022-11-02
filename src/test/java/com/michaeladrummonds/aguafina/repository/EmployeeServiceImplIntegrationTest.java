package com.michaeladrummonds.aguafina.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.michaeladrummonds.aguafina.models.Employee;

@DataJpaTest
public class EmployeeServiceImplIntegrationTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @ParameterizedTest
    @CsvSource({ "1, Michael, Jones, 586 Honeycomb Drive, Los Angeles, CA, 90210" })
    public void testFindEmployeeById(ArgumentsAccessor accessor) {
        Employee e = new Employee();
        e.setId(accessor.getInteger(0));
        e.setFirstName(accessor.getString(1));
        e.setLastName(accessor.getString(2));
        e.setAddress(accessor.getString(3));
        e.setCity(accessor.getString(4));
        e.setState(accessor.getString(5));
        e.setZipCode(accessor.getString(6));
        employeeRepository.save(e);
        Employee found = employeeRepository.findById(accessor.getInteger(0)).get();
        assertEquals(1, found.getId());
    }
}
