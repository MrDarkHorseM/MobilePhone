package com.matianxing.repository;

import com.mtx.domain.Order;
import com.mtx.repository.OrderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        Order a = new Order();
        a.setQuantity(10);
        a.setOrderTotal(new BigDecimal(10.0));
        Order save = orderRepository.save(a);
        Optional<Order> testOrder = orderRepository.findById(a.getId());
        assertNotNull(testOrder);
        assertEquals(a.getId(),testOrder.get().getId());
    }
}
