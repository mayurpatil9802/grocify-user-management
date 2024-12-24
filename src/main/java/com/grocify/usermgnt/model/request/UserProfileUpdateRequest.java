package com.grocify.usermgnt.model.request;

import lombok.Data;

@Data
public class UserProfileUpdateRequest {

    private String firstName;

    private String lastName;

    private String mobileNo;

    private String address;

}
