package com.mtx.service;

import com.mtx.domain.Payment;
import com.mtx.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> finaAll(){
        return paymentRepository.findAll();
    }

    public List<Payment>findByOrder_Id(Long orderId){
        return paymentRepository.findByOrder_Id(orderId);
    }

    public List<Payment>findByPaid_Date(Instant paidDate){
        return paymentRepository.findByPaidDate(paidDate);
    }

    public List<Payment>findByPaymentMethod(String paymentMethod){
        return paymentRepository.findByPaymentMethod(paymentMethod);
    }

    public List<Payment>findByPaymentTotal(BigDecimal paymentTotal){
        return paymentRepository.findByPaymentTotal(paymentTotal);
    }

    public Payment findById(Long id){
        return paymentRepository.findById(id).get();
    }

    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }

}

