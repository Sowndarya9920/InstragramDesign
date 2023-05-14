package com.example.InstagramDesign.service;

import com.example.InstagramDesign.model.AuthenticationToken;
import com.example.InstagramDesign.model.User;
import com.example.InstagramDesign.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo ar;

    public void savetoken(AuthenticationToken token) {
        ar.save(token);
    }

    public AuthenticationToken gettoken(User user) {
        return ar.findByUser(user);
    }

}
