package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProoducts()
	{
		return productRepository.findAll();
	}
	
	public String getProductById(int pid)
	{
		Optional<Product> result=productRepository.findById(pid);
		if(result.isPresent())
		{
			return result.get().toString();	
		}
		else
		{
			return"Product is not present with ID";
		}
	}
	
	public String updateProduct(Product product) {
		Optional<Product> result = productRepository.findById(product.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			p.setPrice(product.getPrice());
			p.setPname(product.getPname());
			productRepository.saveAndFlush(p);
			return "Product details updated successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String deleteProduct(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			Product p = result.get();
			productRepository.delete(p);;
			return "Product details deleted successfully";
		}else {
			return "Product not present";
		}
	}
	public String addProduct(Product product) {
	    // Check if a product with the same ID already exists
	    Optional<Product> existingProduct = productRepository.findById(product.getPid());
	    
	    if (existingProduct.isPresent()) {
	        // Product with the same ID already exists
	        return "Product already exists with the same ID";
	    } else {
	        // Save the new product
	        productRepository.save(product);
	        return "New Product added successfully";
	    }
	}

	
}
