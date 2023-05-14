package com.example.InstagramDesign.controller;

import com.example.InstagramDesign.dto.SignInInput;
import com.example.InstagramDesign.dto.SignUpInput;
import com.example.InstagramDesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService uService;

    @PostMapping(value = "/signUp")
    public String signUp(@RequestBody SignUpInput signUpDto){
        return uService.signUp(signUpDto);
    }

    @PostMapping(value = "/signIn")
    public String signIn(@RequestBody SignInInput signInDto){
        return uService.signIn(signInDto);
    }

    @PutMapping(value = "/update/{id}/{email}")
    public String updateDetails(@PathVariable Integer id, @PathVariable String email){
        return uService.updateDetails(id,email);
    }
}
