package com.study.yaroslavambrozyak.schedulemeapi.dto;

import java.util.Date;


public class RemindDTO {

    private long id;
    private String title;
    private String description;
    private Date date;

    public RemindDTO() {
    }

    public RemindDTO(long id, String title, String description, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}