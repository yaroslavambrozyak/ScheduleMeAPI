package com.study.yaroslavambrozyak.schedulemeapi.config;

import com.study.yaroslavambrozyak.schedulemeapi.entity.User;
import com.study.yaroslavambrozyak.schedulemeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class SecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return s -> {
            User user = userService.findUserByName(s);
            if (user!=null)
                return new org.springframework.security.core.userdetails.User(user.getUserName(),
                        user.getPassword(),true,true,true,
                        true, AuthorityUtils.createAuthorityList("USER"));
            else
                throw new UsernameNotFoundException("could not find user" + s);
        };
    }


}

