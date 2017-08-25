package com.study.yaroslavambrozyak.schedulemeapi.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_acc")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true,length = 30)
    private String userName;
    private String password;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private Set<Remind> remindSet;

    public User() {
    }

    public User(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Remind> getRemindSet() {
        return remindSet;
    }

    public void setRemindSet(Set<Remind> remindSet) {
        this.remindSet = remindSet;
    }
}
