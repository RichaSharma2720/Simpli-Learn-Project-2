package com.sportyshoes.controller;

import com.sportyshoes.DTO.User;
import com.sportyshoes.exception.InvalidOldPasswordException;
import com.sportyshoes.service.UserReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserReportServices service;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private MultiValueMap<String, String> errorMap;

	@PostMapping("/user/add")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}

	@DeleteMapping("/user/delete")
	public void deleteUser(@RequestParam String email, @RequestParam String password) {
		service.deleteUser(email,password);
	}

	@PutMapping("/user/updatePassword")
	public String changeUserPassword(@RequestParam("oldPassword") String oldPassword,
									 @RequestParam("newPassword") String newPassword) {

		User user = service.findUserByEmail(
				SecurityContextHolder.getContext().getAuthentication().getName()+"@gmail.com");

		if(!passwordEncoder.encode(user.getPassword()).equals(oldPassword)){
			throw new InvalidOldPasswordException();
		}
		service.changeUserPassword(oldPassword,newPassword, user.getEmail());
		return "done";
	}

}
