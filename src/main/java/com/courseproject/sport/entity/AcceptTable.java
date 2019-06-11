package com.courseproject.sport.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter@Setter
@Entity
@Table(name = "accept_info")
public class AcceptTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accept_id")
    private Integer acceptId;

    @ManyToOne(targetEntity = InviteTable.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "invite_id", referencedColumnName = "invite_id")
    private InviteTable inviteTable;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "accepter_id", referencedColumnName = "user_openid")
    private User accepter;

    public AcceptTable() {
    }

}
