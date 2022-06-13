package com.sportyshoes.DAO.impl;

import com.sportyshoes.DAO.UserService;
import com.sportyshoes.repository.UserRepository;
import com.sportyshoes.DTO.User;
import com.sportyshoes.assembler.UserAssembler;
import com.sportyshoes.exception.BusinessException;
import com.sportyshoes.exception.UserAlreadyExistException;
import com.sportyshoes.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAssembler assembler;

    @Override
    public User createUser(final User user) {
        if(emailExists(user.getEmail())){
            throw new UserAlreadyExistException("There is an account with that email address: " + user.getEmail());
        }
        UserModel userModel = assembler.dtoToModel(user);
        UserModel result = userRepository.save(userModel);
        return assembler.modelToDTO(result);
    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public User findUserByEmail(String email) {
        return assembler.modelToDTO(userRepository.findByEmail(email));
    }

    @Override
    public User findUserById(Integer id) throws BusinessException {
        return assembler.modelToDTO(userRepository.findById(id).get());
    }

    @Override
    public void deleteUser(String email, String password) {
        UserModel userModel = userRepository.findByEmail(email);
        if(!(userModel.getPassword().equals(password))){
            throw new InvalidParameterException("Wrong password for :" + email);
        }

        userRepository.delete(userModel);
    }

    @Override
    public List<User> getAllUsers() {
        List<UserModel> userModelList = userRepository.findAll();
        return userModelList.stream()
                .map(s->assembler.modelToDTO(s))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findUsersByName(String name) {
        List<UserModel> byFirstName = userRepository.findByFirstName(name);
        return byFirstName.stream()
                .map(s->assembler.modelToDTO(s))
                .collect(Collectors.toList());

    }

    @Override
    public void changeUserPassword(String oldPassword, String newPassword) {

    }
}
