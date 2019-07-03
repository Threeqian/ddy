package com.courseproject.sport.entity;

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

    @Column(name = "invite_id")
    private Integer inviteId;

    @Column(name = "accepter_id")
    private String accepterId;

    public AcceptTable() {
    }

}
