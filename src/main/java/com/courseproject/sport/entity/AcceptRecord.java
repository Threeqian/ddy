package com.courseproject.sport.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accept_record")
public class AcceptRecord implements Serializable {
    @Id
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private String userId;

    @OneToOne(targetEntity = InviteTable.class)
    @JoinColumn(name = "accept_id")
    private Integer acceptId;

    public AcceptRecord() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(Integer acceptId) {
        this.acceptId = acceptId;
    }
}
