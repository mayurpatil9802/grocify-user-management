package com.grocify.usermgnt.dao;

import com.grocify.usermgnt.dto.UserDTO;
import com.grocify.usermgnt.entity.UserEntity;
import com.grocify.usermgnt.mapper.UserMapper;
import com.grocify.usermgnt.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthDao {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UserMapper userMapper;


    public Optional<UserDTO> getUserByEmailIdAndPassword(String emailId) {
        Optional<UserEntity> userDetails = authRepository.findById(emailId);

        if (userDetails.isPresent()){
            UserEntity user = userDetails.get();
            UserDTO userDto = userMapper.userEntityToUserDTO(user);
            return Optional.of(userDto);
        }

        return Optional.empty();
    }

}
