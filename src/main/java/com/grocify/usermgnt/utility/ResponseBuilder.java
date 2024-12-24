package com.grocify.usermgnt.utility;

import com.grocify.usermgnt.dto.UserDTO;
import com.grocify.usermgnt.model.response.LoginResponse;
import com.grocify.usermgnt.model.response.UserResponse;
import org.springframework.stereotype.Component;


@Component
public class ResponseBuilder {

    public LoginResponse buildLoginResponse(String token, UserDTO userDTO) {

        UserResponse userResponse = userDTOToUserResponse(userDTO);

        return LoginResponse.builder()
                .user(userResponse)
                .token(token)
                .build();

    }

    public UserResponse userDTOToUserResponse(UserDTO userDTO) {
        return UserResponse.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .role(userDTO.getRole().name())
                .emailId(userDTO.getEmailId())
                .mobileNo(userDTO.getMobileNo())
                .address(userDTO.getAddress())
                .build();
    }

}
