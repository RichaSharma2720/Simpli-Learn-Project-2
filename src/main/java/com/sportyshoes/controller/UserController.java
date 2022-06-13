package com.sportyshoes.controller;

import com.sportyshoes.DTO.User;
import com.sportyshoes.service.UserReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserReportServices service;

	private MultiValueMap<String, String> errorMap;

	@PostMapping("/user/add")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}

	@DeleteMapping("/user/delete")
	public void deleteUser(@RequestParam String email, @RequestParam String password) {
		service.deleteUser(email,password);
	}

	@PostMapping("/user/updatePassword")
	public String changeUserPassword(@RequestParam("oldPassword") String oldPassword,
									 @RequestParam("newPassword") String newPassword){
		service.changeUserPassword(oldPassword,newPassword);
		return "done";
	}

}
