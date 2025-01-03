package com.grocify.usermgnt.dao;

import com.grocify.usermgnt.dto.UserDTO;
import com.grocify.usermgnt.entity.UserEntity;
import com.grocify.usermgnt.mapper.UserMapper;
import com.grocify.usermgnt.model.request.SignupRequest;
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

    public Optional<UserDTO> getUserByEmailId(String emailId) {
        Optional<UserEntity> userDetails = authRepository.findById(emailId);

        if (userDetails.isPresent() && userDetails.get().getStatus()){
            UserEntity user = userDetails.get();
            UserDTO userDto = userMapper.userEntityToUserDTO(user);
            return Optional.of(userDto);
        }

        return Optional.empty();
    }

    public Optional<UserDTO> insertUserInformation(SignupRequest signupRequest){
        UserEntity user = userMapper.signUpRequestToUserEntity(signupRequest);
        authRepository.save(user);
        UserDTO userDto = userMapper.userEntityToUserDTO(user);
        return Optional.of(userDto);
    }

    public UserDTO updateUserDetails(UserDTO userDTO) {
        UserEntity user = userMapper.userDTOToUserEntity(userDTO);
        authRepository.save(user);
        return userDTO;
    }

}
