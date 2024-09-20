package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
@RequestMapping("/products") 
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProduct()
	{
		return productService.getAllProoducts();
	}
	
	@GetMapping(value="product/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getProductById(@PathVariable("pid") int pid)
	{
		return productService.getProductById(pid);
		
	}
	
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addProduct(@RequestBody Product product)
	{
		return productService.addProduct( product);
	}
	
	@DeleteMapping(value = "/{pid}")
	public String deleteProduct(@PathVariable("pid") int pid) {
		return productService.deleteProduct(pid);
	}
	
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProuct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
}
