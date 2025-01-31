package com.grocify.usermgnt.service;

import com.grocify.usermgnt.dao.AuthDao;
import com.grocify.usermgnt.dto.UserDTO;
import com.grocify.usermgnt.exception.UserNotFoundException;
import com.grocify.usermgnt.model.request.UserProfileUpdateRequest;
import com.grocify.usermgnt.model.response.UserResponse;
import com.grocify.usermgnt.utility.ResponseBuilder;
import com.grocify.usermgnt.validator.UpdateRequestValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private AuthDao authDao;

    @Autowired
    private UpdateRequestValidation updateRequestValidation;

    @Autowired
    private ResponseBuilder responseBuilder;

    public UserResponse updateUserProfile(Long id, UserProfileUpdateRequest userProfileUpdateRequest) {
        updateRequestValidation.validationUpdateRequest(userProfileUpdateRequest);

        Optional<UserDTO> existingUserDetails = authDao.getUserById(id);

        if (existingUserDetails.isEmpty()) {
            throw new UserNotFoundException("User with provided emailId is not present");
        }

        UserDTO userDTO = existingUserDetails.get();
        userDTO.setFirstName(userProfileUpdateRequest.getFirstName());
        userDTO.setLastName(userProfileUpdateRequest.getLastName());
        userDTO.setMobileNo(userProfileUpdateRequest.getMobileNo());
        userDTO.setAddress(userProfileUpdateRequest.getAddress());
        userDTO.setStatus(Boolean.TRUE);
        userDTO.setMetadata(userProfileUpdateRequest.getMetadata());

        userDTO = authDao.updateUserDetails(userDTO);
        return responseBuilder.userDTOToUserResponse(userDTO);
    }

    public UserResponse deleteUserProfile(Long id) {

        Optional<UserDTO> existingUserDetails = authDao.getUserById(id);

        if (existingUserDetails.isEmpty()) {
            throw new UserNotFoundException("User with provided emailId is not present");
        }

        UserDTO userDTO = existingUserDetails.get();
        userDTO.setStatus(Boolean.FALSE);

        userDTO = authDao.updateUserDetails(userDTO);

        return responseBuilder.userDTOToUserResponse(userDTO);
    }

}
