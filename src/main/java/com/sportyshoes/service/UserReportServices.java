package com.sportyshoes.service;

import com.sportyshoes.DAO.UserService;
import com.sportyshoes.DTO.User;
import com.sportyshoes.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReportServices {

    @Autowired
    private UserService service;

    public User createUser(User user) {
        return service.createUser(user);
    }

    public User findUserById(Integer id) {
        try {
            return service.findUserById(id);
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }

    public User findUserByEmail(String email) {
        return service.findUserByEmail(email);
    }

    public void deleteUser(String email, String password) {
        service.deleteUser(email,password);
    }

    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    public List<User> findUsersByName(String name){
        return service.findUsersByName(name);
    }

    public void changeUserPassword(String oldPassword, String newPassword) {
        service.changeUserPassword(oldPassword,newPassword);
    }
}
