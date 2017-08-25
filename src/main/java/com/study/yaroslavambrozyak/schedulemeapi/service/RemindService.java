package com.study.yaroslavambrozyak.schedulemeapi.service;

import com.study.yaroslavambrozyak.schedulemeapi.dto.RemindDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;
import com.study.yaroslavambrozyak.schedulemeapi.exception.RemindNotFoundException;
import com.study.yaroslavambrozyak.schedulemeapi.exception.UserNotFoundException;

import java.util.List;

public interface RemindService {

    List<RemindDTO> getAllUserReminds(long id) throws UserNotFoundException;

    void addRemind(long id,RemindDTO remindDTO) throws UserNotFoundException;

    void updateRemind(long id,RemindDTO remindDTO) throws UserNotFoundException, RemindNotFoundException;

    void deleteRemind(long id) throws RemindNotFoundException;
}
