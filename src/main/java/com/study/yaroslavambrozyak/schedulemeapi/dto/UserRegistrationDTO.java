package com.study.yaroslavambrozyak.schedulemeapi.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationDTO {

    @NotNull
    @Size(min = 4,max = 30)
    private String userName;
    @NotNull
    @Size(min = 4,max = 30)
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
