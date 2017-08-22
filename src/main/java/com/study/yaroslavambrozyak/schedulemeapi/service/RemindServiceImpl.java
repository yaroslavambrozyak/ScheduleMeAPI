package com.study.yaroslavambrozyak.schedulemeapi.service;

import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;
import com.study.yaroslavambrozyak.schedulemeapi.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemindServiceImpl implements RemindService {

    @Autowired
    private RemindRepository remindRepository;

    @Override
    public List<Remind> getReminds() {
        return remindRepository.findAll();
    }

    @Override
    public void addRemind(Remind remind) {
        remindRepository.save(remind);
    }

    @Override
    public void deleteRemind(long id) {
        remindRepository.delete(id);
    }
}
