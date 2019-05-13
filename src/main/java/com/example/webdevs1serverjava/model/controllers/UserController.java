package com.example.webdevs1serverjava.model.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevs1serverjava.model.User;

@RestController
public class UserController {
	private User[] users = { new User(1, "alice", "alice", "Alice", "Wonderland"),
			new User(2, "bob", "bob", "Bob", "The builder"), new User(3, "charlier", "charlier", "Charlier", "Brown") };
	private ArrayList<User> userArrayList = new ArrayList<User>();
	public UserController() {
		userArrayList.add(new User(1, "alice", "alice", "Alice", "Wonderland"));
		userArrayList.add(new User(2, "bob", "bob", "Bob", "The builder"));
		userArrayList.add(new User(3, "charlier", "charlier", "Charlier", "Brown"));
		
	}

	@GetMapping("/api/users")
	public List<User> findAllUsers() {
		return userArrayList;
	}

	@DeleteMapping("api/users/{userId}")
	public  List<User>  deleteUser(@PathVariable("userId") int userId) {
		User u = null;
		for (User user : userArrayList) {
			if (user.getId() == userId) {
				u = user;
			}
		}
		userArrayList.remove(u);
		return userArrayList;
	}
	
	@PostMapping("api/users/create")
	public void create(@PathVariable("user") User user) {
		userArrayList.add(user);
	}
}