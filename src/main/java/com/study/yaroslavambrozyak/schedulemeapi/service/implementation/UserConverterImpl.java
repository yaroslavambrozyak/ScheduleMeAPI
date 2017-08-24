package com.study.yaroslavambrozyak.schedulemeapi.service.implementation;

import com.study.yaroslavambrozyak.schedulemeapi.dto.UserDTO;
import com.study.yaroslavambrozyak.schedulemeapi.dto.UserRegistrationDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.User;
import com.study.yaroslavambrozyak.schedulemeapi.service.UserConverter;
import org.springframework.stereotype.Service;

@Service
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getId(),user.getUserName());
    }

    @Override
    public User convertUserRegistrationDTOToUser(UserRegistrationDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
