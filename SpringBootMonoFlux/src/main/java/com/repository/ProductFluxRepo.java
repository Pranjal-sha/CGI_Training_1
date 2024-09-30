package com.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.entity.ProductFlux;

import reactor.core.publisher.Mono;

public interface ProductFluxRepo extends ReactiveCrudRepository<ProductFlux, Integer>{

	Mono<com.service.ProductFluxService> save(com.service.ProductFluxService product);

}
