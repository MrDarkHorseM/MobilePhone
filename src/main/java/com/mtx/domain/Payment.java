package com.mtx.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

public class Payment {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="orders_id_seq")
    @SequenceGenerator(name="orders_id_seq", sequenceName="orders_id", allocationSize=1)
    private Long id;
}
