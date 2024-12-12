package com.grocify.usermgnt.validator;

import com.grocify.usermgnt.exception.InvalidRequestException;
import com.grocify.usermgnt.model.request.LoginRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class AuthRequestValidator {

    public void validateLoginRequest(LoginRequest loginRequest) {

        if (!StringUtils.hasText(loginRequest.getUsername())) {
            throw new InvalidRequestException("invalid username. username cannot be null or blank");
        }
        if (!StringUtils.hasText(loginRequest.getPassword())) {
            throw new InvalidRequestException("invalid password. password cannot be null or blank");
        }

    }

}
