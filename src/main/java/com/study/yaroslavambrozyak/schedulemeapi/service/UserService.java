package com.study.yaroslavambrozyak.schedulemeapi.service;

import com.study.yaroslavambrozyak.schedulemeapi.dto.UserDTO;
import com.study.yaroslavambrozyak.schedulemeapi.dto.UserRegistrationDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.User;
import com.study.yaroslavambrozyak.schedulemeapi.exception.UserNotFoundException;
import com.study.yaroslavambrozyak.schedulemeapi.exception.UserRegistrationException;


public interface UserService {
    User findUserByName(String userName);

    UserDTO findUserById(long id) throws UserNotFoundException;

    void updateUser(long id, UserDTO userDTO) throws UserNotFoundException;

    void deleteUser(long id) throws UserNotFoundException;

    void register(UserRegistrationDTO user) throws UserRegistrationException;

    public User tryFindUser(long id) throws UserNotFoundException;
}
