package com.mtx.repository;

import com.mtx.domain.Payment;
import com.mtx.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment>findByOrder_Id(String order_id);

}
