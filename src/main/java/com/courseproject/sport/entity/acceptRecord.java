package com.courseproject.sport.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accept_record")
public class acceptRecord implements Serializable {
    @Id
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Integer userId;

    @OneToOne(targetEntity = inviteTable.class)
    @JoinColumn(name = "accept_id")
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
