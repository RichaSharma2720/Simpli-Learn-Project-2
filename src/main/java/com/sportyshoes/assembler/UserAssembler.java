package com.sportyshoes.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportyshoes.DTO.User;
import com.sportyshoes.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserAssembler {

    public UserModel dtoToModel(User user){
        if(user == null){
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(user, UserModel.class);
    }

    public User modelToDTO(UserModel userModel){
        if(userModel == null){
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(userModel, User.class);
    }
}
