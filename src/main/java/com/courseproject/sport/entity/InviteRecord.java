package com.courseproject.sport.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "invite_record")
public class InviteRecord implements Serializable {
    @Id
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private String userId;

    @OneToOne(targetEntity = InviteTable.class)
    @JoinColumn(name = "invite_id")
    private Integer inviteId;

    public InviteRecord() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getInviteId() {
        return inviteId;
    }

    public void setInviteId(Integer inviteId) {
        this.inviteId = inviteId;
    }
}
