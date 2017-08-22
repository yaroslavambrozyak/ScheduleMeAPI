package com.study.yaroslavambrozyak.schedulemeapi.repository;

import com.study.yaroslavambrozyak.schedulemeapi.entity.Remind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemindRepository extends JpaRepository<Remind,Long> {
}
