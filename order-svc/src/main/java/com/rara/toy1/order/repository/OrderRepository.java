package com.rara.toy1.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rara.toy1.order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
