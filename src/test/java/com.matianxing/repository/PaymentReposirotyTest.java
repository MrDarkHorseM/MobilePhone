package com.matianxing.repository;

import com.mtx.config.AppConfig;
import com.mtx.domain.Payment;
import com.mtx.repository.PaymentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@ContextConfiguration(classes = {AppConfig.class})
public class PaymentReposirotyTest {
    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        Payment t = new Payment();
        t.setPaymentMethod("credit card");
        t.setPaymentTotal("1888");
        Payment save = paymentRepository.save(t);
        Optional<Payment> testPayment = paymentRepository.findById(t.getId());
        assertNotNull(testPayment);
        assertEquals(t.getId(),testPayment.get().getId());
    }

    @Test
    @Transactional
    public void findByOrderTest() {




    }





}
