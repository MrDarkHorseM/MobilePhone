package com.mtx.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

public class Payment {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="payments_id_seq")
    @SequenceGenerator(name="payments_id_seq", sequenceName="payments_id", allocationSize=1)
    private Long id;

    @Column(name="payment_method")
    String paymentMethod;






}
