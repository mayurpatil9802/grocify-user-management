package com.grocify.usermgnt.controller;

import com.grocify.usermgnt.model.request.UserProfileUpdateRequest;
import com.grocify.usermgnt.model.response.UserResponse;
import com.grocify.usermgnt.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PutMapping("/{emailId}")
    public UserResponse updateProfile(@PathVariable String emailId, @RequestBody UserProfileUpdateRequest userProfileUpdateRequest) {
        return userProfileService.updateUserProfile(emailId, userProfileUpdateRequest);
    }
    @GetMapping("/{emailId}")
    public void deleteProfile(@PathVariable String emailId){
        userProfileService.deleteUserProfile(emailId);
    }




}
