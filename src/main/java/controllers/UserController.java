package controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevs1serverjava.model.User;

@RestController
public class UserController {
	private User[] users = { new User(1, "alice", "alice", "Alice", "Wonderland"),
			new User(2, "bob", "bob", "Bob", "The builder"), new User(3, "charlier", "charlier", "Charlier", "Brown") };
	List<User> userArrayList = (List<User>) Arrays.asList(users);

	@GetMapping("/api/users")
	public User[] findAllUsers() {
		return users;
	}

	@DeleteMapping("/users/{userId}")
	public User[] deleteUser(@PathVariable("userId") int userId) {
		User u = null;
		for (User user : userArrayList) {
			if (user.getId() == userId) {
				u = user;
			}
		}
		userArrayList.remove(u);
		return users;
	}
}