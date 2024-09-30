package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.OrderMono;
import com.repository.OrderMonoRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderMonoService {

	@Autowired
    private  OrderMonoRepo orderRepository;

   
//    public Mono<OrderMono> createOrder(OrderMono order) {
//        return orderRepository.save(order);
//    }

    public Flux<OrderMono> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<OrderMono> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public Mono<Void> deleteOrder(Integer id) {
        return  orderRepository.deleteById(id);
    }

	public Mono<OrderMono> createOrder(OrderMono order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}
}
