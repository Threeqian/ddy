package com.courseproject.sport.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "invite_record")
public class inviteRecord implements Serializable {
    @Id
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Integer userId;

    @OneToOne(targetEntity = inviteTable.class)
    @JoinColumn(name = "invite_id")
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
