package com.mtx.api.v1;

import com.mtx.domain.Order;
import com.mtx.domain.Payment;
import com.mtx.repository.PaymentRepository;
import com.mtx.service.OrderService;
import com.mtx.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@ResponseBody
@RequestMapping(value = {"/api/payments","/api/payment"})
public class PaymentController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Payment> getPaymentList(){
        logger.debug("list payments");
        return new ArrayList<>();
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Payment findById(@PathVariable("Id") Long id){
        logger.debug("this payment id is"+id);
        return paymentService.findById(id);
    }

    @RequestMapping(value = "/order/{id}",method = RequestMethod.POST)
    public Payment generatorPayment(@RequestBody Payment payment, @PathVariable("id") Long id ){
        Order order = orderService.findById(id);
        payment.setOrder(order);
        return paymentService.save(payment);}

    @RequestMapping(method=RequestMethod.GET,params = {"paymentMethod"})
    public List<Payment> getPaymentByPaymentMethod(@RequestParam(value="paymentMethod") String paymentMethod){
        logger.debug("parameter name is "+paymentMethod);
        List<Payment> payment = paymentService.findByPaymentMethod(paymentMethod);
        return payment;
    }

}
