package com.study.yaroslavambrozyak.schedulemeapi.dto;

public class UserRegistrationDTO {

    private String userName;
    private String password;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
