package com.grocify.usermgnt.mapper;

import com.grocify.usermgnt.dto.UserDTO;
import com.grocify.usermgnt.entity.UserEntity;
import org.springframework.stereotype.Component;

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

}
