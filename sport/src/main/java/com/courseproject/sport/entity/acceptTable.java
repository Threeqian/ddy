package com.courseproject.sport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accept_info")
public class acceptTable {
    @Id
    @Column(name = "invite_id")
    private Integer inviteId;
    @Column(name = "accepter_id")
    private Integer accepterId;

    public acceptTable() {
    }

    public Integer getInviteId() {
        return inviteId;
    }

    public void setInviteId(Integer inviteId) {
        this.inviteId = inviteId;
    }

    public Integer getAccepterId() {
        return accepterId;
    }

    public void setAccepterId(Integer accepterId) {
        this.accepterId = accepterId;
    }
}
