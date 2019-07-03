package com.courseproject.sport.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter@Setter
@Entity
@Table(name = "invite_info")
public class InviteTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invite_id")
    private Integer id;

    @Column(name = "inviter_id")
    private String inviterId;

    @NotBlank
    @Column(name = "invite_sport_type")
    private String sportType;

    @NotBlank
    @Column(name = "invite_location")
    private String location;

    @Column(name = "invite_description")
    private String description;

    @Column(name = "announce_date")
    private Date announceDate;

    @Column(name = "valid_day")
    private Integer validDay;

    @NotNull
    @Min(1)
    @Column(name = "invite_number")
    private Integer number;

    @NotNull
    @Column(name = "is_evalute")
    private Integer is_evaluate = 0;

    @NotNull
    @Column(name = "is_accept")
    private Integer is_accept = 0;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "finish_time")
    private String finishTime;

    private User user;

    public InviteTable() {
    }
}
