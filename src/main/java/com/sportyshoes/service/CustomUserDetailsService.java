package com.sportyshoes.service;

import com.sportyshoes.model.CustomUserDetails;
import com.sportyshoes.model.UserModel;
import com.sportyshoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = this.userRepository.findByEmail(username);
        if(userModel == null){
            throw new UsernameNotFoundException("NO USER");
        }
        return new CustomUserDetails(userModel);
    }
}
