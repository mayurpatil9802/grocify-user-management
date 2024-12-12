package com.grocify.usermgnt.controller;


import com.grocify.usermgnt.model.request.LoginRequest;
import com.grocify.usermgnt.model.response.LoginResponse;
import com.grocify.usermgnt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public LoginResponse userInformation(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

}
