package com.courseproject.sport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "is_evaluate")
    private Integer is_evaluate;

    @NotNull
    @Column(name = "is_evaluate")
    private Integer is_accept;

    public InviteTable() {
    }
}
