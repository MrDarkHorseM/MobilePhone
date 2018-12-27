package com.mtx.domain;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

public class Payment {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="payments_id_seq")
    @SequenceGenerator(name="payments_id_seq", sequenceName="payments_id_seq", allocationSize=1)
    private Long id;

    @Column(name="paid_date")
    private Instant paidDate;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="payment_total")
    private BigDecimal paymentTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orders_id_seq")
    private Order order;

    public Long getId(){ return id;}

    public Instant getPaidDate() { return paidDate;}
    public void setPaidDate(Instant paidDate){ this.paidDate = paidDate;}

    public String getPaymentMethod() { return paymentMethod;}
    public void setPaymentMethod( String paymentMethod){ this.paymentMethod = paymentMethod;}

    public BigDecimal getPaymentTotal(){ return paymentTotal;}
    public void setPaymentTotal( String paymentMethod){ this.paymentMethod = paymentMethod;}

    public Order order() { return order;}
    public void setOrder( Order order){ this.order = order;}
}
