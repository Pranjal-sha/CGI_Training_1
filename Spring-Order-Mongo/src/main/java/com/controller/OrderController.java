package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collection.OrderCollection;
import com.netflix.spectator.impl.PatternExpr.Or;
import com.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping(value="orders",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderCollection> getAllOrder()
	{
		return orderService.getAllOrder();
	}
	
	@GetMapping(value="order/{orderNo}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getOrderById(@PathVariable("orderNo") int orderNo)
	{
		return orderService.getOrderById(orderNo);
	}
	
	@PostMapping(value = "add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addNewOrder(@RequestBody OrderCollection order)
	{
		return orderService.addNewOrder(order);
	}
	
	@PutMapping(value = "edit/{orderNo}")
	public String editOrderById(@PathVariable("orderNo") int orderNo, @RequestBody OrderCollection order)
	{
		return orderService.editOrderById(order);
		
	}
	
	@DeleteMapping(value = "delete/{orderNo}")
	public String deleteById(@PathVariable("orderNo") int orderNo)
	{
		return orderService.deleteById(orderNo);
	}
	
	@GetMapping(value = "userById",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderCollection> getOrderByUserId(int orderNo)
	{
		return orderService.getOrderByUserId(orderNo);
	}
	
	
}
