package com.mtx.domain;


import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="orders_id_seq")
    @SequenceGenerator(name="orders_id_seq", sequenceName="orders_id", allocationSize=1)
    private Long id;

    @Column(name="order_date")
    Date orderDate; //why no modifier?

    @Column
    Integer quantity;

    @Column(name="order_total")
    BigDecimal orderTotal;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order",cascade = CascadeType.ALL) //why only SQL?

//  @Column(name="payment_id")

    private List<Payment> payments; //?

    @Column(name="paid_date")
    Date paidDate;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name="users_id")
    private User user;

//    public void set why?
}
