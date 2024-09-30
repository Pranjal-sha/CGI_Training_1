package com.service;

import org.springframework.stereotype.Service;

import com.entity.ProductFlux;
import com.repository.ProductFluxRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductFluxService {

    private final ProductFluxRepo productFluxRepository;

    public ProductFluxService(ProductFluxRepo productFluxRepository) {
        this.productFluxRepository = productFluxRepository;
    }

    public Mono<ProductFluxService> save(ProductFluxService product) {
        return productFluxRepository.save(product);
    }
    public Mono<ProductFlux> findById(int id) {
        return productFluxRepository.findById(id);
    }

    public Flux<ProductFlux> findAll() {
        return productFluxRepository.findAll(); 
    }

    public Mono<Void> deleteById(int id) {
        return productFluxRepository.deleteById(id);
    }
    
    
}
