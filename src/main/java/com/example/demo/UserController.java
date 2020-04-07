package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.User;
import com.example.demo.models.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping()
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User foundUser = userRepository.findById(id).orElse(null);
		if (foundUser == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(foundUser);
	}

	@PostMapping()
	public User addUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> removeUser(@PathVariable int id) {
		User foundUser = userRepository.findById(id).orElse(null);
		if (foundUser == null) {
			return ResponseEntity.notFound().build();
		}
		userRepository.delete(foundUser);
		return ResponseEntity.ok(foundUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
		User foundUser = userRepository.findById(id).orElse(null);
		if(foundUser == null) {
			return ResponseEntity.notFound().build();
	}
		if(user.getFirstName() !=null) {
			foundUser.setFirstName(user.getFirstName());
		}
		userRepository.save(foundUser);
		return ResponseEntity.ok(foundUser);
		
	}

	
}

