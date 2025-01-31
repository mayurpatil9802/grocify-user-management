package com.grocify.usermgnt.model.request;

import lombok.Data;

import java.util.Map;

@Data
public class UserProfileUpdateRequest {

    private String firstName;

    private String lastName;

    private String mobileNo;

    private String address;

    private Map<String, String> metadata;

}
