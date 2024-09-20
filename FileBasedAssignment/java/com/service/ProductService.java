package com.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.entity.Product;

public class ProductService {
	private List<Product> listOfProduct = new ArrayList<Product>();
	 private static final String FILE_NAME = "products.dat";
	 
	 public ProductService() {
	        deserializeProducts();
	    }
	
	public String addProduct(Product product) {
		int flag=0;
		if(listOfProduct.size()==0)
		{
			listOfProduct.add(product);
			serializeProducts();
			return"Product added successfully";
		}
		else
		{
			Iterator<Product> li= listOfProduct.iterator();
			while(li.hasNext())
			{
				Product p=li.next();
				if(p.getPid()==product.getPid())
				{
				flag++;
				break;
				}
			}
		}
		if(flag==0)
		{
			listOfProduct.add(product);
			serializeProducts();
			return"Product is added successfully";
		}
		else
		{

			flag =0;
			return "Product is must be unique";
		}
		
	}
	
	public List<Product> findAllProduct()
	{
		return listOfProduct;
	}
	
	public String updatetProduct(Product product) {
		int flag = 0;		
		Iterator<Product>	li = listOfProduct.iterator();
		while(li.hasNext()) {
		Product p  = li.next();
		if(p.getPid()==product.getPid()) {
			p.setPrice(product.getPrice());
			serializeProducts();
				flag++;
				break;
				}
		}
		if(flag==0) {
			return "Product not present";
		}else {
			flag =0;
			return "Product price updated successfully";
		}
	}
	
	public String deleteProduct(int pid) {
		int flag = 0;		
		Iterator<Product>	li = listOfProduct.iterator();
		while(li.hasNext()) {
		Product p  = li.next();
		if(p.getPid()==pid) {
			li.remove();
			serializeProducts();
				flag++;
				break;
				}
		}
		if(flag==0) {
			return "Product not present";
		}else {
			flag =0;
			return "Product deleted successfully";
		}
	}
	
	private void serializeProducts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(listOfProduct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void deserializeProducts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            listOfProduct = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Handle file not found or class issues gracefully
            // For a fresh start, you might want to initialize an empty list
            listOfProduct = new ArrayList<>();
        }
    }


}
