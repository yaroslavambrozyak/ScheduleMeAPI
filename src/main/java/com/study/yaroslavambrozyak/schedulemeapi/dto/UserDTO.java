package com.study.yaroslavambrozyak.schedulemeapi.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

    private long id;
    @NotNull
    @Size(min = 4,max = 30)
    private String userName;

    public UserDTO() {
    }

    public UserDTO(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
