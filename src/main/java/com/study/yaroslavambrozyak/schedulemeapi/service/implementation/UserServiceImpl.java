package com.study.yaroslavambrozyak.schedulemeapi.service.implementation;

import com.study.yaroslavambrozyak.schedulemeapi.dto.UserDTO;
import com.study.yaroslavambrozyak.schedulemeapi.dto.UserRegistrationDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.User;
import com.study.yaroslavambrozyak.schedulemeapi.exception.UserNotFoundException;
import com.study.yaroslavambrozyak.schedulemeapi.exception.UserRegistrationException;
import com.study.yaroslavambrozyak.schedulemeapi.repository.UserRepository;
import com.study.yaroslavambrozyak.schedulemeapi.service.UserConverter;
import com.study.yaroslavambrozyak.schedulemeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:exceptionmessages.properties")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    Environment environment;

    @Override
    public User findUserByName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public UserDTO findUserById(long id) throws UserNotFoundException {
        return userConverter.convertUserToUserDTO(tryFindUser(id));
    }

    @Override
    public void updateUser(long id, UserDTO userDTO) throws UserNotFoundException {
        User user = tryFindUser(id);
        user.setUserName(userDTO.getUserName());
    }

    @Override
    public void deleteUser(long id) throws UserNotFoundException {
        tryFindUser(id);
        userRepository.delete(id);
    }

    @Override
    public void register(UserRegistrationDTO user) throws UserRegistrationException {
        User foundUser = userRepository.findUserByUserName(user.getUserName());
        if (foundUser != null) {
            throw new UserRegistrationException("exception.user-exist");
        }
        userRepository.save(userConverter.convertUserRegistrationDTOToUser(user));
    }

    public User tryFindUser(long id) throws UserNotFoundException {
        User user = userRepository.findUserById(id);
        if (user == null)
            throw new UserNotFoundException(environment.getProperty("exception.user-not-found"));
        return user;
    }

}
