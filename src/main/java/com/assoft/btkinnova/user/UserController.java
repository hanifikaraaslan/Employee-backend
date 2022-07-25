package com.assoft.btkinnova.user;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/users/")
public class UserController {
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping("getall")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("getbyuser/{id}")
	public User getOneUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		throw new RuntimeException(String.format("Employee with %s id could not found", id));
	}

	@PostMapping("add")
	public User addUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	@PostMapping("adds")
	public List<User> addUsers(@RequestBody List<User> list) {
		userRepository.saveAll(list);
		return list;
	}

	@PutMapping("update/{id}")
	public User getUpdateUser(@PathVariable(name = "id", required = true) int id, @RequestBody User user) {
		User userUpdate = userRepository.findById(id).orElse(null);
		if (userUpdate != null) {
			userUpdate.setEmail(user.getEmail());
			userUpdate.setPassword(user.getPassword());

			return userRepository.save(userUpdate);
		}
		throw new RuntimeException("Error");
	}
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		User user= userRepository.findById(id).orElse(null);
		if(user!=null) {
		 userRepository.delete(user);
		 return "silindi";
			}
		throw new RuntimeException("Error");
		
	}

}
