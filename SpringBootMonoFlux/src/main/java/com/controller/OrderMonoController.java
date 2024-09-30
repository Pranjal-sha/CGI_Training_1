package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.OrderMono;
import com.service.OrderMonoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderMonoController {

	@Autowired
    private  OrderMonoService orderService;

  

    @PostMapping
    public Mono<OrderMono> createOrder(@RequestBody OrderMono order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public Flux<OrderMono> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Mono<OrderMono> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteOrder(@PathVariable Integer id) {
        return orderService.deleteOrder(id);
    }
}
