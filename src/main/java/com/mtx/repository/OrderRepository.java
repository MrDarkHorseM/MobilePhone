package com.mtx.repository;

import com.mtx.domain.Order;
import com.mtx.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

   // List<Order>findBy

}
