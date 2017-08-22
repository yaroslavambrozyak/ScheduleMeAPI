package com.study.yaroslavambrozyak.schedulemeapi.repository;

import com.study.yaroslavambrozyak.schedulemeapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUserName(String userName);

}
