package com.michaeladrummonds.aguafina.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.michaeladrummonds.aguafina.models.Customer;
import com.michaeladrummonds.aguafina.models.Employee;
import com.michaeladrummonds.aguafina.models.Order;
import com.michaeladrummonds.aguafina.models.OrderDetails;
import com.michaeladrummonds.aguafina.models.Product;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderServiceImplIntegrationTest {

        @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private OrderDetailsRepository orderDetailsRepository;

        @Autowired
        private CustomerRepository customerRepository;

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private EmployeeRepository employeeRepository;

        @Test
        public void testFindOrderByCustomerId() {
                Product p = new Product(1, "MWBLU20", "Blueberry", 20, 2.0, "ACTIVE", "blueberry.png");
                productRepository.save(p);

                Customer c = new Customer(1, "Carol", "Shaw", "cshaw@mlb.com", "206-804-8771", "8157 Longview Court",
                                "Seattle",
                                "WA", "98121", null);
                customerRepository.save(c);

                Employee e = new Employee();
                e.setId(1);
                e.setFirstName("Jack");
                e.setLastName("Powell");
                e.setEmail("jpowell0@hplussport.com");
                e.setAddress("5 Jenifer Crossing");
                e.setCity("Lynchburg");
                e.setState("VA");
                e.setZipCode("24515");
                e.setOrders(new ArrayList<>());
                e.setUser(null);
                employeeRepository.save(e);
                employeeRepository.save(e);

                OrderDetails od = new OrderDetails(1, productRepository.findById(1).get(), 10, 20.0, new Date());
                orderDetailsRepository.save(od);

                Order o = new Order(1, orderDetailsRepository.findById(1).get(), customerRepository.findById(1).get(),
                                employeeRepository.findById(1).get());
                orderRepository.save(o);

                List<Order> foundOrders = orderRepository.findByCustomerId(c, 1);

                assertFalse(foundOrders.isEmpty());
        }

        @Test
        public void testSumTotalByCustomer() {
                Product p1 = new Product(1, "MWBLU20", "Blueberry", 20, 2.0, "ACTIVE", "blueberry.png");
                productRepository.save(p1);
                Product p2 = new Product(2, "MWBLU32", "Blueberry", 32, 4.0, "ACTIVE", "blueberry.png");
                productRepository.save(p2);

                Customer c = new Customer(1, "Carol", "Shaw", "cshaw@mlb.com", "206-804-8771", "8157 Longview Court",
                                "Seattle",
                                "WA", "98121", null);
                customerRepository.save(c);

                Employee e = new Employee();
                e.setId(1);
                e.setFirstName("Jack");
                e.setLastName("Powell");
                e.setEmail("jpowell0@hplussport.com");
                e.setAddress("5 Jenifer Crossing");
                e.setCity("Lynchburg");
                e.setState("VA");
                e.setZipCode("24515");
                e.setOrders(new ArrayList<>());
                e.setUser(null);
                employeeRepository.save(e);

                OrderDetails od1 = new OrderDetails(1, productRepository.findById(1).get(), 10, 20.0, new Date());
                orderDetailsRepository.save(od1);
                OrderDetails od2 = new OrderDetails(2, productRepository.findById(2).get(), 5, 20.0, new Date());
                orderDetailsRepository.save(od2);

                Order o1 = new Order(1, orderDetailsRepository.findById(1).get(), customerRepository.findById(1).get(),
                                employeeRepository.findById(1).get());
                orderRepository.save(o1);
                Order o2 = new Order(2, orderDetailsRepository.findById(2).get(), customerRepository.findById(1).get(),
                                employeeRepository.findById(1).get());
                orderRepository.save(o2);

                Double total = orderRepository.sumTotalByCustomer(c, 1);
                assertEquals(40, total);
        }
}
