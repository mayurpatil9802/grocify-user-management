package com.grocify.usermgnt.dto;

import com.grocify.usermgnt.enums.UserRole;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

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

    private Boolean status;

    private LocalDate lastLogin;

}
