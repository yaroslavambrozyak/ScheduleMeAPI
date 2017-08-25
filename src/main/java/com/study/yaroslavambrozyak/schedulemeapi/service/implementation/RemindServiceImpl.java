package com.study.yaroslavambrozyak.schedulemeapi.service.implementation;

import com.study.yaroslavambrozyak.schedulemeapi.dto.RemindDTO;
import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;
import com.study.yaroslavambrozyak.schedulemeapi.entity.User;
import com.study.yaroslavambrozyak.schedulemeapi.exception.RemindNotFoundException;
import com.study.yaroslavambrozyak.schedulemeapi.exception.UserNotFoundException;
import com.study.yaroslavambrozyak.schedulemeapi.repository.RemindRepository;
import com.study.yaroslavambrozyak.schedulemeapi.repository.UserRepository;
import com.study.yaroslavambrozyak.schedulemeapi.service.RemindConverter;
import com.study.yaroslavambrozyak.schedulemeapi.service.RemindService;
import com.study.yaroslavambrozyak.schedulemeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemindServiceImpl implements RemindService {

    @Autowired
    private RemindRepository remindRepository;
    @Autowired
    private RemindConverter remindConverter;
    @Autowired
    private Environment environment;
    @Autowired
    private UserService userService;

    @Override
    public List<RemindDTO> getAllUserReminds(long id) throws UserNotFoundException {
        userService.tryFindUser(id);
        return remindRepository.findAllByUserId(id).stream()
                .map(remindConverter::convertRemindToRemindDTO).collect(Collectors.toList());
    }

    @Override
    public void addRemind(long id, RemindDTO remindDTO) throws UserNotFoundException {
        User user = userService.tryFindUser(id);
        Remind remind = remindConverter.convertRemindDTOToRemind(remindDTO);
        remind.setUser(user);
        remindRepository.save(remind);
    }

    @Override
    public void updateRemind(long id, RemindDTO remindDTO) throws RemindNotFoundException {
        Remind remind = tryFindRemind(id);
        remind.setTitle(remindDTO.getTitle());
        remind.setDescription(remindDTO.getDescription());
        remind.setDate(remindDTO.getDate());
    }

    @Override
    public void deleteRemind(long id) throws RemindNotFoundException {
        tryFindRemind(id);
        remindRepository.delete(id);
    }

    private Remind tryFindRemind(long id) throws RemindNotFoundException {
        Remind remind = remindRepository.findOne(id);
        if (remind == null)
            throw new RemindNotFoundException(environment.getProperty("exception.remind-not-found"));
        return remind;
    }
}
