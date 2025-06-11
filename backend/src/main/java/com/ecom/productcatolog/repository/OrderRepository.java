package com.ecom.productcatolog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.productcatolog.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
