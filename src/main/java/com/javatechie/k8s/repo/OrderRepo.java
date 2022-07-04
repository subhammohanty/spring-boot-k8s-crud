package com.javatechie.k8s.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.k8s.entity.Order;


public interface OrderRepo extends JpaRepository<Order, Integer> {
	
}
