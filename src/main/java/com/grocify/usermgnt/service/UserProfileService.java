package com.grocify.usermgnt.service;

import com.grocify.usermgnt.dao.AuthDao;
import com.grocify.usermgnt.dto.UserDTO;
import com.grocify.usermgnt.exception.InvalidRequestException;
import com.grocify.usermgnt.exception.UserNotFoundException;
import com.grocify.usermgnt.model.request.UserProfileUpdateRequest;
import com.grocify.usermgnt.model.response.UserResponse;
import com.grocify.usermgnt.utility.ResponseBuilder;
import com.grocify.usermgnt.validator.UpdateRequestValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private AuthDao authDao;

    @Autowired
    private UpdateRequestValidation updateRequestValidation;

    @Autowired
    private ResponseBuilder responseBuilder;

    public UserResponse updateUserProfile(String emailId, UserProfileUpdateRequest userProfileUpdateRequest) {
        updateRequestValidation.validationUpdateRequest(userProfileUpdateRequest);

        Optional<UserDTO> existingUserDetails = authDao.getUserByEmailId(emailId);

        if(existingUserDetails.isEmpty()){
            throw new UserNotFoundException("User with provided emailId is not present");
        }

        UserDTO userDTO = existingUserDetails.get();
        userDTO.setFirstName(userProfileUpdateRequest.getFirstName());
        userDTO.setLastName(userProfileUpdateRequest.getLastName());
        userDTO.setMobileNo(userProfileUpdateRequest.getMobileNo());
        userDTO.setAddress(userProfileUpdateRequest.getAddress());

        userDTO = authDao.updateUserDetails(userDTO);
        return responseBuilder.userDTOToUserResponse(userDTO);
    }

    public UserResponse deleteUserProfile(String email){

        if (!StringUtils.hasText(email)) {
            throw new InvalidRequestException("Email id Id cannot be null or empty");
        }

        Optional<UserDTO> existingUserDetails = authDao.getUserByEmailId(email);

        if(existingUserDetails.isEmpty()){
            throw new UserNotFoundException("User with provided emailId is not present");
        }

        UserDTO userDTO = existingUserDetails.get();
        userDTO.setStatus(Boolean.FALSE);

        userDTO = authDao.updateUserDetails(userDTO);

        return responseBuilder.userDTOToUserResponse(userDTO);
    }

}
