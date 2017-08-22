package com.study.yaroslavambrozyak.schedulemeapi.service;

import com.study.yaroslavambrozyak.schedulemeapi.entity.User;

import java.util.List;

public interface UserService {
    User findUserByName(String userName);
    List<User> getUsers();
}
