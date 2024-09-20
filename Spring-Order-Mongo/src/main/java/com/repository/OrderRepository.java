package com.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.collection.OrderCollection;

@Repository
public interface OrderRepository extends MongoRepository<OrderCollection, Integer> {

	List<OrderCollection> findByUserId(Integer userId);

}
