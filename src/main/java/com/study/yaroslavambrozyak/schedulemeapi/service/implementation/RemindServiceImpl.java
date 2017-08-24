package com.study.yaroslavambrozyak.schedulemeapi.service.implementation;

import com.study.yaroslavambrozyak.schedulemeapi.dto.RemindDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;
import com.study.yaroslavambrozyak.schedulemeapi.repository.RemindRepository;
import com.study.yaroslavambrozyak.schedulemeapi.service.RemindConverter;
import com.study.yaroslavambrozyak.schedulemeapi.service.RemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemindServiceImpl implements RemindService {

    @Autowired
    private RemindRepository remindRepository;
    @Autowired
    private RemindConverter remindConverter;

    @Override
    public List<RemindDTO> getAllUserReminds(long id) {
        return remindRepository.findAllByUserId(id).stream()
                .map(remindConverter::convertRemindToRemindDTO).collect(Collectors.toList());
    }

    @Override
    public void addRemind(RemindDTO remind) {
        remindRepository.save(remindConverter.convertRemindDTOToRemind(remind));
    }

    @Override
    public void deleteRemind(long id) {
        remindRepository.delete(id);
    }
}
