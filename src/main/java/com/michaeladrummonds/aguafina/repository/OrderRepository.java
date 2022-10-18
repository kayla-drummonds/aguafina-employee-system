package com.michaeladrummonds.aguafina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.michaeladrummonds.aguafina.models.Customer;
import com.michaeladrummonds.aguafina.models.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Long> {

    @Query("select o from Order o where o.customer = ?1")
    List<OrderDetails> getOrderByCustomerId(Customer customer, Long id);
}
