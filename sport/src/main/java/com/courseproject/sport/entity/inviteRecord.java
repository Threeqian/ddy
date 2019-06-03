package com.courseproject.sport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invite_record")
public class inviteRecord {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "invite_id")
    private Integer inviteId;

    public inviteRecord() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInviteId() {
        return inviteId;
    }

    public void setInviteId(Integer inviteId) {
        this.inviteId = inviteId;
    }
}
