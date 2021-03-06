package com.courseproject.sport.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter@Setter
@Entity
@Table(name = "user_info")
public class User implements Serializable {

    @Id
    @NotNull
    @Column(name = "user_openid",unique = true)//对应表中的列
    String id;

    @NotNull
    @Column(name = "user_name")
    private String name;

    @Column(name = "user_img")
    private String userImg;

    @Column(name = "user_introduction")
    private String introduction;

    @Column(name = "user_tag")
    private String tag;

    @Column(name = "user_score")
    private Double score;

    public User() {
    }
}
