package com.sportyshoes.DAO;

import com.sportyshoes.DTO.User;
import com.sportyshoes.exception.BusinessException;

import java.util.List;


public interface UserService {

	public User createUser(User user);
//	public User updateUser(User user);
	public User findUserById(Integer id) throws BusinessException;
	public void deleteUser(String email, String password);
	public List<User> getAllUsers();
	public List<User> findUsersByName(String name);

	public User findUserByEmail(String email);

    public void changeUserPassword(String oldPassword, String newPassword);
}
