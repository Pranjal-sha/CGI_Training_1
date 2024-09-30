package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderMono {
	 @Id
	    private String id;
	    private String product;
	    private int quantity;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getProduct() {
			return product;
		}
		public void setProduct(String product) {
			this.product = product;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public OrderMono(String id, String product, int quantity) {
			super();
			this.id = id;
			this.product = product;
			this.quantity = quantity;
		}
		public OrderMono() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "OrderMono [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
		}

	    
}
