package com.javatechie.k8s.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.k8s.entity.Order;
import com.javatechie.k8s.repo.OrderRepo;

@Service
public class OrderServiceImpl {
	
	@Autowired
	private OrderRepo orderRepo;
	
	
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}
	
	public Order getOrderById(int id) {
		 Optional<Order> findById = orderRepo.findById(id);
		 if(!findById.isEmpty()) {
			 return findById.get();
		 }else {
			 return null;
		 }
	}

}
