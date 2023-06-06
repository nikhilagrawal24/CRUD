package com.CrudOperation.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CrudOperation.Exception.NotFound;
import com.CrudOperation.Model.User;
import com.CrudOperation.Repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	public UserRepository userRepository;

	
	@GetMapping("/users")
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}
	
    // get data	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<User>> GetUserById(@PathVariable int id) {

		Optional<User> user = userRepository.findById(id);
		if (user == null) {
			throw new NotFound("No data Found");
		}
		return ResponseEntity.ok(user);
	}
	// add data
	@PostMapping("/add")
	public User AddUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
   
	// update data
	@PutMapping("/update/{id}")
	public ResponseEntity<User> UpdateUser(@PathVariable int id, @RequestBody User user) {

		User user2 = userRepository.findById(id).orElseThrow(() -> new NotFound("No data found"));

		user2.setName(user.getName());
		user2.setNumber(user.getNumber());
		user2.setEmail(user.getEmail());

		User UpdateUser = userRepository.save(user2);
		return ResponseEntity.ok(UpdateUser);
	}

	// delete data
	@DeleteMapping("/delete/{id}")
	public void DeleteUser(@PathVariable int id) {

		User user = this.userRepository.findById(id).get();
		this.userRepository.delete(user);

	}

}
