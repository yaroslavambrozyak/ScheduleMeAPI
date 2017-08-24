package com.study.yaroslavambrozyak.schedulemeapi.service;

import com.study.yaroslavambrozyak.schedulemeapi.dto.UserDTO;
import com.study.yaroslavambrozyak.schedulemeapi.dto.UserRegistrationDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.User;



public interface UserService {
    User findUserByName(String userName);
    UserDTO findUserById(long id);
    void deleteUser(long id);
    void register(UserRegistrationDTO user);
}