package com.mtx.repository;

import com.mtx.domain.Payment;
import com.mtx.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment>findAll();

    @Query("SELECT p from Payment p join fetch p.order where p.order.id=?1")
    List<Payment>findByOrder_Id(Long orderId);

    List<Payment>findByPaidDate(Instant paidDate);

    List<Payment>findByPaymentMethod(String paymentMethod);

    List<Payment>findByPaymentTotal(BigDecimal paymentTotal);

    Optional<Payment> findById(Long id);
}
