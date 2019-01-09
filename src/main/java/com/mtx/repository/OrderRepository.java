package com.mtx.repository;

import com.mtx.domain.Order;
import com.mtx.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

   List<Order>findAll();

   Optional<Order> findById(Long Id);

   List<Order> findByOrderDate(Instant orderDate);

   List<Order> findByUser_Id(Long Id);

   List<Order>findByQuantity(Integer quantity);

   List<Order>findByOrderTotal(BigDecimal orderTotal);

}
