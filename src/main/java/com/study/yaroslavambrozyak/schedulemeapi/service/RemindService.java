package com.study.yaroslavambrozyak.schedulemeapi.service;

import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;

import java.util.List;

public interface RemindService {

    List<Remind> getReminds();

    void addRemind(Remind remind);

    void deleteRemind(long id);
}
