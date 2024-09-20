package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	RestTemplate restTemplate;
	
	public List<User> saveUser(User user)
	{
		 userRepository.save(user);
		 return userRepository.findAll();
		
	}
	
	public String getUserById(String userId ) {
		Optional<User> result=userRepository.findById(userId);
		if(result.isPresent())
		{
			return result.get().toString();
		}
		else
		{
			return"Could not get the user by ID";
		}
	}
	
	public String addNewUser(User user)
	{
		Optional<User> userID =userRepository.findById(user.getUserId());
		Optional<User> userName=userRepository.findById(user.getUsername());
		if(userName.isEmpty())
		{
			userRepository.save(user);
			return user.toString();
		}
		else
		{
			return"Could not update the user details";
		}
	}
	
	public String deleteUser(String userId)
	{
		 Optional<User> result = userRepository.findById(userId);
		    if (result.isPresent()) {
		        userRepository.deleteById(userId);
		        return "User deleted successfully";
		    } else {
		        return "Could not find the user by ID";
		    }
	}
	

}
