package com.collection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.bouncycastle.pqc.legacy.math.ntru.polynomial.ProductFormPolynomial;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class OrderCollection {
	@Id
	private int orderNo;
	private int userId;
	private LocalDateTime ltd =LocalDateTime.now();
	private LocalDate ld=LocalDate.now();
	@DBRef
	private List<ProductCollection> product;
	public OrderCollection(int orderNo, int userId, LocalDateTime ltd, LocalDate ld, List<ProductCollection> product) {
		super();
		this.orderNo = orderNo;
		this.userId = userId;
		this.ltd = ltd;
		this.ld = ld;
		this.product = product;
	}
	public OrderCollection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDateTime getLtd() {
		return ltd;
	}
	public void setLtd(LocalDateTime ltd) {
		this.ltd = ltd;
	}
	public LocalDate getLd() {
		return ld;
	}
	public void setLd(LocalDate ld) {
		this.ld = ld;
	}
	public List<ProductCollection> getProduct() {
		return product;
	}
	public void setProduct(List<ProductCollection> product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderCollection [orderNo=" + orderNo + ", userId=" + userId + ", ltd=" + ltd + ", ld=" + ld
				+ ", product=" + product + "]";
	}
	
	
	
}
