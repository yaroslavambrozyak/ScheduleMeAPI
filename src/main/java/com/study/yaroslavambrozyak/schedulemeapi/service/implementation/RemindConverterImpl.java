package com.study.yaroslavambrozyak.schedulemeapi.service.implementation;

import com.study.yaroslavambrozyak.schedulemeapi.dto.RemindDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;
import com.study.yaroslavambrozyak.schedulemeapi.service.RemindConverter;
import org.springframework.stereotype.Service;

@Service
public class RemindConverterImpl implements RemindConverter {
    @Override
    public RemindDTO convertRemindToRemindDTO(Remind remind) {
        return new RemindDTO(remind.getId(),remind.getTitle(),remind.getDescription(),remind.getDate());
    }

    @Override
    public Remind convertRemindDTOToRemind(RemindDTO remindDTO) {
        Remind remind = new Remind();
        remind.setTitle(remindDTO.getTitle());
        remind.setDescription(remindDTO.getDescription());
        remind.setDate(remindDTO.getDate());
        return remind;
    }
}
