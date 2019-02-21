package com.mtx.service;

import com.mtx.config.AppConfig;
import com.mtx.domain.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@ContextConfiguration(classes = {AppConfig.class})
public class PaymentServiceTest {
    @Autowired
    private PaymentService paymentSevice;

    @Test
    @Transactional
    public void findByIdTest() {
        Payment t = new Payment();
        t.setPaymentMethod("credit card");
        t.setPaymentTotal("1888");
        Payment save = paymentSevice.save(t);
        Payment testPayment = paymentSevice.findById(t.getId());
        assertNotNull(testPayment);
        assertEquals(t.getId(),testPayment.getId());
    }

}
