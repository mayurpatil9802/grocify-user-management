package com.grocify.usermgnt.dto;

import com.grocify.usermgnt.enums.UserRole;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDTO {

    private String emailId;

    private String firstName;

    private String lastName;

    private String mobileNo;

    private String address;

    private String password;

    private UserRole role;

    private Date lastLogin;

}
