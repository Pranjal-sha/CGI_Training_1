package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.collection.OrderCollection;
import com.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
    private final String USER_SERVICE_URL = "http://SPRING-USER-HT/Login/get/"; // provide the correct url to access the user

	
	public List<OrderCollection> getAllOrder()
	{
		return orderRepository.findAll();
	}
	
	public String getOrderById(int orderNo)
	{
		Optional<OrderCollection> result= orderRepository.findById(orderNo);
		if(result.isPresent())
		{
			return result.toString();
		}
		else
		{
			return"Could not find the Order with this ID";
		}
		
	}
	
	public String addNewOrder(OrderCollection order)
	{
		// using restTemplate to get UserID
		String userServiceUrl = USER_SERVICE_URL + order.getUserId();// this line can be replaced by actual URL
        String userResponse = restTemplate.getForObject(userServiceUrl, String.class);

        if (userResponse == null ) {
            return "Invalid user ID; order cannot be placed.";
        }
        
		Optional<OrderCollection> result = orderRepository.findById(order.getOrderNo());
		if(result.isEmpty())
		{
			orderRepository.save(order);
			return "Order added successfully";
		}
		else
		{
			return" Could not add the order";
		}
				
	}
	
	public String editOrderById(OrderCollection orderUp)
	{
		Optional<OrderCollection> result = orderRepository.findById(orderUp.getOrderNo());
		if(result.isPresent())
		{
			orderRepository.save(orderUp);
			return result.get().toString();
		}
		else
		{
			return"Could not remove the order with this ID";
		}
	}
	
	public String deleteById(int orderNo)
	{
		Optional<OrderCollection> result = orderRepository.findById(orderNo);
		if(result.isPresent())
		{
			orderRepository.deleteById(orderNo);
			return result.get().toString();
		}
		else
		{
			return"Could not delete the order";
		}
	}
	
	public List<OrderCollection> getOrderByUserId (int userId)
	{
		return orderRepository.findByUserId(userId);
	}
	

}
