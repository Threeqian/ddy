package com.courseproject.sport.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accept_info")
public class acceptTable implements Serializable {
    @Id
    @OneToOne(targetEntity = inviteTable.class)
    @JoinColumn(name = "invite_id")
    private Integer inviteId;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "accepter_id")
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
