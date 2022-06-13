package com.sportyshoes.DAO.repository;

import com.sportyshoes.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

    UserModel findByEmail(String email);

    List<UserModel> findByFirstName(String firstName);


}
