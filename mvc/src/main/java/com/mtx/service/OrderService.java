package com.mtx.service;

import com.mtx.domain.Order;
import com.mtx.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
//        List<User> users = Lists.newArrayList(userRepository.findAll());
        return orderRepository.findAll();
    }

    public Order findById(Long Id){
        return orderRepository.findById(Id).get();
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public List<Order> findByOrderDate(Instant orderDate){
        return orderRepository.findByOrderDate(orderDate);
    }

    public List<Order> findByUser_Id(Long Id){
        return orderRepository.findByUser_Id(Id);
    }

    public List<Order> findByQuantity(Integer quantity){
        return orderRepository.findByQuantity(quantity);
    }

    public List<Order> findByOrderTotal(BigDecimal orderTotal){
        return orderRepository.findByOrderTotal(orderTotal);
    }

}
