package com.courseproject.sport.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accept_info")
public class AcceptTable implements Serializable {
    @Id
    @OneToOne(targetEntity = InviteTable.class)
    @JoinColumn(name = "invite_id")
    private Integer inviteId;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "accepter_id")
    private String accepterId;

    public AcceptTable() {
    }

    public Integer getInviteId() {
        return inviteId;
    }

    public void setInviteId(Integer inviteId) {
        this.inviteId = inviteId;
    }

    public String getAccepterId() {
        return accepterId;
    }

    public void setAccepterId(String accepterId) {
        this.accepterId = accepterId;
    }
}
