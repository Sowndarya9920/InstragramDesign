package com.example.InstagramDesign.repository;

import com.example.InstagramDesign.model.AuthenticationToken;
import com.example.InstagramDesign.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends CrudRepository<AuthenticationToken , Long> {
    AuthenticationToken findByUser(User user);

}
