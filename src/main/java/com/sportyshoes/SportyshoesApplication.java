package com.sportyshoes;

import com.sportyshoes.model.UserModel;
import com.sportyshoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SportyshoesApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserModel user = new UserModel();
		user.setFirstName("tarun");
		user.setLastName("sharma");
		user.setEmail("tarun@gmail.com");
		user.setRole("admin");
		user.setPassword(this.bCryptPasswordEncoder.encode("tarun"));

		this.userRepository.save(user);

		UserModel user2 = new UserModel();
		user2.setFirstName("richa");
		user2.setLastName("sharma");
		user2.setEmail("richa@gmail.com");
		user2.setRole("admin");
		user2.setPassword(this.bCryptPasswordEncoder.encode("richa"));

		this.userRepository.save(user2);
	}
}
