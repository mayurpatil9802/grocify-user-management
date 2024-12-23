package com.grocify.usermgnt.mapper;

import com.grocify.usermgnt.dto.UserDTO;
import com.grocify.usermgnt.entity.UserEntity;
import com.grocify.usermgnt.model.request.SignupRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {

    public UserDTO userEntityToUserDTO(UserEntity userEntity) {
        return UserDTO.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .mobileNo(userEntity.getMobileNo())
                .address(userEntity.getAddress())
                .role(userEntity.getRole())
                .emailId(userEntity.getEmailId())
                .password(userEntity.getPassword())
                .lastLogin(userEntity.getLastLogin())
                .build();
    }
    public UserEntity signUpRequestToUserEntity(SignupRequest signupRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(signupRequest.getFirstName());
        userEntity.setLastName(signupRequest.getLastName());
        userEntity.setMobileNo(signupRequest.getMobileNo());
        userEntity.setAddress(signupRequest.getAddress());
        userEntity.setRole(signupRequest.getRole());
        userEntity.setEmailId(signupRequest.getEmailId());
        userEntity.setPassword(signupRequest.getPassword());
        userEntity.setLastLogin(LocalDate.now());
        userEntity.setStatus(Boolean.TRUE);
        return userEntity;
    }


}
