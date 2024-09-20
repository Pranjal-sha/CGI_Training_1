package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.collection.ProductCollection;

public interface ProductRepository extends MongoRepository<ProductCollection, Integer>{

}
