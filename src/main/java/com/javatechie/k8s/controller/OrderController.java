package com.javatechie.k8s.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.k8s.entity.Order;
import com.javatechie.k8s.service.OrderServiceImpl;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping("/order")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		Order saveOrder = orderService.saveOrder(order);
		return new ResponseEntity<Order>(saveOrder, HttpStatus.CREATED);
	}

	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> allOrders = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(allOrders, HttpStatus.OK);
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable int id) {
		Order orderById = orderService.getOrderById(id);
		return new ResponseEntity<Order>(orderById, HttpStatus.OK);
	}

}
