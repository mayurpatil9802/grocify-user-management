package com.grocify.usermgnt.model.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNo;
    private String address;
    private String role;

}
