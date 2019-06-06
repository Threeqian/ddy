package com.courseproject.sport.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "invite_info")
public class InviteTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invite_id")
    private Integer id;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "inviter_id")
    private String inviter_id;

    @Column(name = "invite_description")
    private String description;

    @Column(name = "announce_date")
    private String announceDate;

    @Future
    @Column(name = "valid_date")
    private String validDate;

    @NotNull
    @Size(min = 1)
    @Column(name = "invite_number")
    private Integer number;

    @NotBlank
    @Column(name = "invite_location")
    private String location;

    @NotBlank
    @Column(name = "invite_sportType")
    private String sportType;

    public InviteTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInviter_id() {
        return inviter_id;
    }

    public void setInviter_id(String inviter_id) {
        this.inviter_id = inviter_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }
}
