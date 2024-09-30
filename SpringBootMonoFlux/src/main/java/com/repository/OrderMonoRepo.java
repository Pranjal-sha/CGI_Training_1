package com.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.entity.OrderMono;
import com.service.OrderMonoService;

import reactor.core.publisher.Mono;

public interface OrderMonoRepo extends ReactiveCrudRepository<OrderMono, Integer>{

	Mono<OrderMono> save(OrderMonoService order);

}
