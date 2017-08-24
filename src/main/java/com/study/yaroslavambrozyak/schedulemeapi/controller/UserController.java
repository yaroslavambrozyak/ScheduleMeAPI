package com.study.yaroslavambrozyak.schedulemeapi.controller;

import com.study.yaroslavambrozyak.schedulemeapi.dto.UserDTO;
import com.study.yaroslavambrozyak.schedulemeapi.dto.UserRegistrationDTO;
import com.study.yaroslavambrozyak.schedulemeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") long id){
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void register(UserRegistrationDTO user){
        userService.register(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }

}
