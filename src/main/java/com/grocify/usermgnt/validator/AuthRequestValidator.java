package com.grocify.usermgnt.validator;

import com.grocify.usermgnt.exception.InvalidRequestException;
import com.grocify.usermgnt.model.request.LoginRequest;
import com.grocify.usermgnt.model.request.SignupRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class AuthRequestValidator {


    public void validateLoginRequest(LoginRequest loginRequest) {

        if (!StringUtils.hasText(loginRequest.getUsername())) {
            throw new InvalidRequestException("Invalid username. username cannot be null or blank");
        }

        if (!StringUtils.hasText(loginRequest.getPassword())) {
            throw new InvalidRequestException("Invalid password. password cannot be null or blank");
        }

    }

    public void validateSignUpRequest(SignupRequest signupRequest) {
        if (StringUtils.hasText(signupRequest.getEmailId())) {
            String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(signupRequest.getEmailId());
            if (!matcher.matches()) {
                throw new InvalidRequestException("Invalid email");
            }
        } else {
            throw new InvalidRequestException("Invalid email id. Email id cannot be null or blank");
        }

        if (StringUtils.hasText(signupRequest.getPassword())) {
            String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(signupRequest.getPassword());

            if (!matcher.matches()) {
                throw new InvalidRequestException("Invalid password .Password should have minimum 8 characters in length. Adjust it by modifying \n" +
                        "At least one uppercase English letter. You can remove this condition by removing \n" +
                        "At least one lowercase English letter.  You can remove this condition by removing \n" +
                        "At least one digit. You can remove this condition by removing \n" +
                        "At least one special character,  You can remove this condition by removing\n");
            }

            if (!signupRequest.getPassword().equals(signupRequest.getConfirmPassword())) {
                throw new InvalidRequestException("Password do not match with conform password.");
            }
        } else {
            throw new InvalidRequestException("Invalid password. Email cannot be null or blank");
        }

        if (signupRequest.getMobileNo().length() != 10) {
            throw new InvalidRequestException("Invalid Mobile No. Mobile number must be 10 digits long.");
        }

        if (Objects.isNull(signupRequest.getMetadata())) {
            signupRequest.setMetadata(new HashMap<>());
        }

    }
}


