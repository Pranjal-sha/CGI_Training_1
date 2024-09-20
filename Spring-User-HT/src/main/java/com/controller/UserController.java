package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("Login")
public class UserController {
	@Autowired
	UserService userService;
	
	
	    @PostMapping(value="/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public List<User> saveUser(@RequestBody User user) {
	        return userService.saveUser(user);
	    }

	    @GetMapping(value="get/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
	    public String getUserById(@PathVariable String userId) {
	        return userService.getUserById(userId);
	    }

	    @PostMapping(value="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public String addNewUser(@RequestBody User user) {
	        return userService.addNewUser(user);
	    }

	    @DeleteMapping(value="delete/{userId}")
	    public String deleteUser(@PathVariable String userId) {
	        return userService.deleteUser(userId);
	    }
	}



