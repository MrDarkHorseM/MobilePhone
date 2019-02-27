package com.mtx.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="orders_id_seq")
    @SequenceGenerator(name="orders_id_seq", sequenceName="orders_id_seq", allocationSize=1)
    private Long id;

    @Column(name="order_date")
    private Instant orderDate;
//    @Column(name="new_date")
    @Transient
    private LocalDate newDate;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="order_total")
    private BigDecimal orderTotal;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order",cascade = CascadeType.ALL)
    private List<Payment> payments;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;


    public Long getId() { return id;}

    public Instant getOrderDate() { return orderDate;}
    public void setOrderDate(Instant orderDate) { this.orderDate = orderDate; }

    public Integer getQuantity() { return quantity;}
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getOrderTotal() {return orderTotal;}
    public void setOrderTotal(BigDecimal orderTotal) { this.orderTotal = orderTotal;}

    public List getPayments() { return payments;}
    public void setPayments(List payments) { this.payments = payments;}

    public User getUser() { return user;}
    public void setUser( User user){ this.user = user;}

    public LocalDate getNewDate() {
        return newDate;
    }

    public void setNewDate(LocalDate newDate) {
        this.newDate = newDate;
    }
}
