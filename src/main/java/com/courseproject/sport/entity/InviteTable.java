package com.courseproject.sport.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Getter@Setter
@Entity
@Table(name = "invite_info")
public class InviteTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invite_id")
    private Integer id;

    @OneToMany(mappedBy = "inviteTable", cascade = CascadeType.ALL)
    private Set<AcceptTable> acceptTables = new HashSet<>();

//    @OneToOne(targetEntity = User.class)
//    @JoinColumn(name = "inviter_id")
//    private String inviterId;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "inviter_id",referencedColumnName = "user_openid")
    private User inviter;

    @Column(name = "invite_description")
    private String description;

    @Column(name = "announce_date")
    private String announceDate;

    //@Future
    @Column(name = "valid_date")
    private String validDate;

    @NotNull
    @Min(1)
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
}
