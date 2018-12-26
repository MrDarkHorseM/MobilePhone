package com.mtx.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

public class Item {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="items_id_seq")
    @SequenceGenerator(name="items_id_seq", sequenceName="items_id", allocationSize=1)
    private Long id;

    @Column(name="item_category")
    private String itemcategory;

    @Column(name="brand_name")
    private String brandname;

    @Column(name="item_name")
    private String itemname;

    @Column(name="price")
    private int price;

    public long getId() { return id;}

    public String getItemcategory() { return itemcategory; }
    public void setItemcategory(String itemcategory) { this.itemcategory = itemcategory; }

    public String getBrandname(){ return brandname; }
    public void setBrandname(String brandname) { this.brandname = brandname; }

    public String getItemname(){ return itemname; }
    public void setItemname(String itemname) { this.itemname = itemname; }

    public int getPrice() { return price; }
    public void setPrice( int price ){this.price = price;}
}
