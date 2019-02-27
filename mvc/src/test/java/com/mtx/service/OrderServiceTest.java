package com.mtx.service;

import com.mtx.config.AppConfig;
import com.mtx.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@ContextConfiguration(classes = {AppConfig.class})
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    public void findByIdTest() {
        Order a = new Order();
        a.setQuantity(10);
        a.setOrderTotal(new BigDecimal(10.0));
        Order save = orderService.save(a);
        Order testOrder = orderService.findById(a.getId());
        assertNotNull(testOrder);
        assertEquals(a.getId(),testOrder.getId());
    }
}
