package com.study.yaroslavambrozyak.schedulemeapi.controller;


import com.study.yaroslavambrozyak.schedulemeapi.dto.RemindDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;
import com.study.yaroslavambrozyak.schedulemeapi.service.RemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/remind")
public class RemindController {

    @Autowired
    private RemindService remindService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public List<RemindDTO> getAllUserReminds(@PathVariable("id") long id){
        return remindService.getAllUserReminds(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addRemind(@PathVariable("id") long id, RemindDTO remind){
        remindService.addRemind(id,remind);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteRemind(@PathVariable("id") long id){
        remindService.deleteRemind(id);
    }

}
