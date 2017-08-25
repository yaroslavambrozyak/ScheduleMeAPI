package com.study.yaroslavambrozyak.schedulemeapi.controller;

import com.study.yaroslavambrozyak.schedulemeapi.dto.UserDTO;
import com.study.yaroslavambrozyak.schedulemeapi.dto.UserRegistrationDTO;
import com.study.yaroslavambrozyak.schedulemeapi.exception.UserNotFoundException;
import com.study.yaroslavambrozyak.schedulemeapi.exception.UserRegistrationException;
import com.study.yaroslavambrozyak.schedulemeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") long id) throws UserNotFoundException {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void updateUser(@Valid UserDTO user){

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) throws UserNotFoundException {
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void register(@Valid UserRegistrationDTO user) throws UserRegistrationException {
        userService.register(user);
    }

}
