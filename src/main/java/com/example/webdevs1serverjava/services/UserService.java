package com.example.webdevs1serverjava.services;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevs1serverjava.models.Course;
import com.example.webdevs1serverjava.models.User;
import com.example.webdevs1serverjava.repositories.CourseRepository;
import com.example.webdevs1serverjava.repositories.UserRepository;

@CrossOrigin(allowCredentials = "true")
@RestController
public class UserService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/api/register")
	public User createUser(@RequestBody User user, HttpSession session) {
		session.setAttribute("currUser", user);
		return userRepository.save(user);
	}
	
	@PostMapping("/api/login")
	public User login(@RequestBody User loginUser, HttpSession session) {
		System.out.println(loginUser.getUsername());
		List<User> users = (List<User>) this.findAllusers();
		for(User user : users) {
			if(user.getUsername().equals(loginUser.getUsername()) && user.getPassword().equals(loginUser.getPassword())) {
				session.setAttribute("currUser", user);
				return user;
			}
		}
		return null;
	}
	
	@GetMapping("/api/profile")
	public User profile(HttpSession session) {
		return (User)session.getAttribute("currUser");
	}
	
	@GetMapping("/api/users")
	public Iterable<User> findAllusers() {
		return userRepository.findAll();
	}

	
	@GetMapping("/api/user/{userId}")
	public User findUserById(
			@PathVariable("userId") Integer userId) {
		return userRepository.findById(userId);
	}
	
	@PutMapping("/api/user/{userId}")
	public @ResponseBody User updateUser(@PathVariable("userId") Integer id, @RequestBody User newUser, HttpSession session) {
		User user = userRepository.findById(id);
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setRole(newUser.getRole());
		userRepository.save(user);
		
		return user;
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") Integer id) {
		User user = userRepository.findById(id);
		userRepository.delete(user);
		System.out.print("DELETERE");
	}

	
	
}