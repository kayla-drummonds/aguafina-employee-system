package com.michaeladrummonds.aguafina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.michaeladrummonds.aguafina.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.email = ?1")
    List<Customer> findByEmail(String email);

    @Query("select c from Customer c where c.phone = ?1")
    List<Customer> findByPhone(String phone);
}
