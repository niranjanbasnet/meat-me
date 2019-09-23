package com.niranjan.Meatme.repository;

import com.niranjan.Meatme.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderItem, Integer> {

}
