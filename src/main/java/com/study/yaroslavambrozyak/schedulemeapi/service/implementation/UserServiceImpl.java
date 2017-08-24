package com.study.yaroslavambrozyak.schedulemeapi.service.implementation;

import com.study.yaroslavambrozyak.schedulemeapi.dto.UserDTO;
import com.study.yaroslavambrozyak.schedulemeapi.dto.UserRegistrationDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.User;
import com.study.yaroslavambrozyak.schedulemeapi.repository.UserRepository;
import com.study.yaroslavambrozyak.schedulemeapi.service.UserConverter;
import com.study.yaroslavambrozyak.schedulemeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public User findUserByName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public UserDTO findUserById(long id) {
        User user = userRepository.findUserById(id);
        return userConverter.convertUserToUserDTO(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(id);
    }

    @Override
    public void register(UserRegistrationDTO user) {
        User foundUser = userRepository.findUserByUserName(user.getUserName());
        if (foundUser!=null) {
            // todo throw exception
        }
        userRepository.save(userConverter.convertUserRegistrationDTOToUser(user));
    }


}
