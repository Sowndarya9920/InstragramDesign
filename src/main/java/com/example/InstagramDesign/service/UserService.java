package com.example.InstagramDesign.service;


import com.example.InstagramDesign.dto.SignInInput;
import com.example.InstagramDesign.dto.SignUpInput;
import com.example.InstagramDesign.model.AuthenticationToken;
import com.example.InstagramDesign.model.User;
import com.example.InstagramDesign.repository.IUserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jakarta.xml.bind.DatatypeConverter;


@Service
public class UserService {
    @Autowired
    IUserRepo uDto;

    @Autowired
    AuthenticationService as;

    public String signUp(SignUpInput signUpDto) {
        User user=uDto.findFirstByEmail(signUpDto.getUserEmail());
        if(user!=null){
            throw new IllegalStateException("User already exist..Sign in instead..!");
        }
        String encryptedpassword=null;
        try {
            encryptedpassword=encryptedpassword(signUpDto.getUserPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
        user=new User(signUpDto.getUserFirstName(),signUpDto.getUserLastName(),
                signUpDto.getUserAge(),signUpDto.getUserEmail(),
                signUpDto.getUserPhoneNumber(),encryptedpassword);
        uDto.save(user);

        AuthenticationToken token=new AuthenticationToken(user);
        as.savetoken(token);
        return "User registered successfully";
    }

    private String encryptedpassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5= MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested=md5.digest();
        String hash= DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public String signIn(SignInInput signInDto) {
        User user=uDto.findFirstByEmail(signInDto.getUserEmail());
        if(user==null){
            throw new IllegalStateException("Invalid user..Sign up instead..");
        }
        String encryptedpassword=null;
        try {
            encryptedpassword=encryptedpassword(signInDto.getUserPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        boolean isvalid=encryptedpassword.equals(user.getPassword());
        if(!isvalid){
            throw new IllegalStateException("signup instead..!");
        }
        AuthenticationToken auth=as.gettoken(user);
        return "User signed in successfully.."+auth.getToken()+" is generated..!";
    }

    @Transactional
    public String updateDetails(Integer id, String email) {
        uDto.updateUser(id,email);
        return "User details updated successfully...";
    }
}
