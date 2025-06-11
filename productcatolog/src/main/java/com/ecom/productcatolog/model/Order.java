package com.ecom.productcatolog.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Order() {}

    public Order(List<OrderItem> items) {
        this.items = items;
    }

    public Long getId() { return id; }
    public List<OrderItem> getItems() { return items; }
}

