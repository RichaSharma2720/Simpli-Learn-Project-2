package com.sportyshoes.controller;

import java.util.List;

import com.sportyshoes.DTO.User;
import com.sportyshoes.service.UserReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sportyshoes.DAO.UserService;

@RestController
@RequestMapping("/api")
public class UserSearchController {

	@Autowired
	private UserReportServices service;

	@GetMapping("/user/all")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/user/search/{name}")
	public List<User> findUsersByName(@PathVariable String name) {
		return service.findUsersByName(name);
	}

	@GetMapping("/user/search/{id}")
	public ResponseEntity<User> getUserById (@PathVariable Integer id) {
		return new ResponseEntity<>(service.findUserById(id), HttpStatus.OK);
	}

	@GetMapping("/user/search")
	public ResponseEntity<User> findUserByName (@RequestParam String email) {
		return new ResponseEntity<>(service.findUserByEmail(email),HttpStatus.OK);
	}




}
