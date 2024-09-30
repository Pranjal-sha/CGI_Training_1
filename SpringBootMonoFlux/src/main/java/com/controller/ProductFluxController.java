package com.controller;

	import com.entity.ProductFlux;
import com.service.ProductFluxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.*;
	import reactor.core.publisher.Flux;
	import reactor.core.publisher.Mono;

	@RestController
	@RequestMapping("/products")
	public class ProductFluxController {

		@Autowired
	    private  ProductFluxService productFluxService;


	    @PostMapping
	    public Mono<ProductFluxService> createProduct(@RequestBody ProductFluxService product) {
	        return productFluxService.save(product);
	    }

	    @GetMapping("/{id}")
	    public Mono<ProductFlux> getProductById(@PathVariable int id) {
	        return productFluxService.findById(id);
	    }

	    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	    public Flux<ProductFlux> getAllProducts() {
	        return productFluxService.findAll();
	    }

	    @DeleteMapping("/{id}")
	    public Mono<Void> deleteProduct(@PathVariable int id) {
	        return productFluxService.deleteById(id);
	    }
	}

