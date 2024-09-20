package com.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long accno;

	    private String name;
	    private double amount;
		public Long getAccno() {
			return accno;
		}
		public void setAccno(Long accno) {
			this.accno = accno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public Account(Long accno, String name, double amount) {
			super();
			this.accno = accno;
			this.name = name;
			this.amount = amount;
		}
		public Account() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Account [accno=" + accno + ", name=" + name + ", amount=" + amount + "]";
		}
	    

}
