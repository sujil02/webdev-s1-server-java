package com.example.webdevs1serverjava.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevs1serverjava.model.Role;
import com.example.webdevs1serverjava.model.User;

@RestController
public class UserController {
	private User[] users = { new User(1, "alice", "alice", "Alice", "Wonderland"),
			new User(2, "bob", "bob", "Bob", "The builder"), new User(3, "charlier", "charlier", "Charlier", "Brown") };
	private ArrayList<User> userArrayList = new ArrayList<User>();

	public UserController() {
		userArrayList.add(new User(1, "alice", "alice", "Alice", "Wonderland", Role.FACULTY));
		userArrayList.add(new User(2, "bob", "bob", "Bob", "The builder", Role.ADMIN));
		userArrayList.add(new User(3, "charlier", "charlier", "Charlier", "Brown", Role.FACULTY));

	}

	@GetMapping("/api/users")
	public List<User> findAllUsers() {
		return userArrayList;
	}

	@DeleteMapping("api/users/{userId}")
	public List<User> deleteUser(@PathVariable("userId") long userId) {
		User u = null;
		for (User user : userArrayList) {
			if (user.getId() == userId) {
				u = user;
			}
		}
		userArrayList.remove(u);
		return userArrayList;
	}

	@PostMapping("/api/users")
	public List<User> create(@RequestBody User user) {
		userArrayList.add(new User(user.getId(), user.getUsername(), user.getPassword(), user.getFirstName(),
				user.getLastName(), user.getRole()));
		return userArrayList;
	}
	
	@PutMapping("/api/users")
	public List<User> update(@RequestBody User updateuser) {
		for (User user : userArrayList) {
			if (user.getId() == updateuser.getId()) {
				user.setUsername(updateuser.getUsername());
				user.setPassword(updateuser.getPassword());
				user.setLastName(updateuser.getLastName());
				user.setFirstName(updateuser.getFirstName());
				user.setRole(updateuser.getRole());
			}
		}
		return userArrayList;
	}
}