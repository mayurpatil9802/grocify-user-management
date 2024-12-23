package com.grocify.usermgnt.model.request;

import com.grocify.usermgnt.enums.UserRole;
import lombok.Data;


@Data
public class SignupRequest {

    private String emailId;

    private String firstName;

    private String lastName;

    private String mobileNo;

    private String address;

    private String password;

    private String confirmPassword;

    private UserRole role;

}
