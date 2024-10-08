package com.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy
	    private String userId;
	    private String username;
	    private String password;
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(String userId, String username, String password) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
		}
	    
	    

}
