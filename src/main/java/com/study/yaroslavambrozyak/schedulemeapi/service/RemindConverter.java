package com.study.yaroslavambrozyak.schedulemeapi.service;

import com.study.yaroslavambrozyak.schedulemeapi.dto.RemindDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;

public interface RemindConverter {

    RemindDTO convertRemindToRemindDTO(Remind remind);

    Remind convertRemindDTOToRemind(RemindDTO remindDTO);
}
