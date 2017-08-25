package com.study.yaroslavambrozyak.schedulemeapi.service;

import com.study.yaroslavambrozyak.schedulemeapi.dto.UserDTO;
import com.study.yaroslavambrozyak.schedulemeapi.dto.UserRegistrationDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.User;

public interface UserConverter {

    UserDTO convertUserToUserDTO(User user);
    User convertUserRegistrationDTOToUser(UserRegistrationDTO userDTO);
}
