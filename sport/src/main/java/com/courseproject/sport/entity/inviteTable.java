package com.courseproject.sport.entity;

import javax.persistence.*;

@Entity
@Table(name = "invite_info")
public class inviteTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invite_id")
    private Integer id;
    @Column(name = "inviter_id")
    private Integer inviter_id;
    @Column(name = "invite_discription")
    private String discription;
    @Column(name = "announce_date")
    private String announceDate;
    @Column(name = "valid_date")
    private String validDate;
    @Column(name = "invite_number")
    private Integer number;

    public inviteTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInviter_id() {
        return inviter_id;
    }

    public void setInviter_id(Integer inviter_id) {
        this.inviter_id = inviter_id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
