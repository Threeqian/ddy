package com.courseproject.sport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accept_record")
public class acceptRecord {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "accept_id")
    private Integer acceptId;

    public acceptRecord() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(Integer acceptId) {
        this.acceptId = acceptId;
    }
}
