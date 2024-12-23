package com.grocify.usermgnt.service;


import com.grocify.usermgnt.dao.AuthDao;
import com.grocify.usermgnt.dto.UserDTO;
import com.grocify.usermgnt.exception.InvalidCredentialsException;
import com.grocify.usermgnt.exception.UserNotFoundException;
import com.grocify.usermgnt.model.request.LoginRequest;
import com.grocify.usermgnt.model.request.SignupRequest;
import com.grocify.usermgnt.model.response.LoginResponse;
import com.grocify.usermgnt.utility.JWTUtility;
import com.grocify.usermgnt.utility.ResponseBuilder;
import com.grocify.usermgnt.validator.AuthRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRequestValidator authRequestValidator;

    @Autowired
    private AuthDao authDao;

    @Autowired
    private ResponseBuilder responseBuilder;

    @Autowired
    private JWTUtility jwtUtility;

    public LoginResponse login(LoginRequest loginRequest) {
        authRequestValidator.validateLoginRequest(loginRequest);
        Optional<UserDTO> optionalUserDetails = authDao.getUserByEmailIdAndPassword(loginRequest.getUsername());

        if(optionalUserDetails.isEmpty()){
            throw new UserNotFoundException("User with provided emailId is not present");
        }

        UserDTO user = optionalUserDetails.get();

        if(!user.getPassword().equals(loginRequest.getPassword())){
            throw new InvalidCredentialsException("incorrect password");
        }

        return responseBuilder.buildLoginResponse(jwtUtility.buildJWT(user), user );
    }


    public LoginResponse signUp(SignupRequest signupRequest) {
        authRequestValidator.validateSignUpRequest(signupRequest);
        Optional<UserDTO> user = authDao.insertUserInformation(signupRequest);
        return responseBuilder.buildLoginResponse(jwtUtility.buildJWT(user.get()), user.get() );
    }
}
