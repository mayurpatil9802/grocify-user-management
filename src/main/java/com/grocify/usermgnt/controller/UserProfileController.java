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

    @PutMapping("/{id}")
    public UserResponse updateProfile(@PathVariable Long id, @RequestBody UserProfileUpdateRequest userProfileUpdateRequest) {
        return userProfileService.updateUserProfile(id, userProfileUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteProfile(@PathVariable Long id) {
        return userProfileService.deleteUserProfile(id);
    }


}
