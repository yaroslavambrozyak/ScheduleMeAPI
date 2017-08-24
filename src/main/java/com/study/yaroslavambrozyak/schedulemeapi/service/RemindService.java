package com.study.yaroslavambrozyak.schedulemeapi.service;

import com.study.yaroslavambrozyak.schedulemeapi.dto.RemindDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;

import java.util.List;

public interface RemindService {

    List<RemindDTO> getAllUserReminds(long id);

    void addRemind(long id,RemindDTO remindDTO);

    void deleteRemind(long id);
}
