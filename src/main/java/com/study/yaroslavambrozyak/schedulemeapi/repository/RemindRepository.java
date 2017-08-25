package com.study.yaroslavambrozyak.schedulemeapi.repository;

import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemindRepository extends JpaRepository<Remind,Long> {

    List<Remind> findAllByUserId(long id);
}
