package com.courseproject.sport.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "user_info")
public class User implements Serializable {
    @Id
    @NotNull
    @Column(name = "user_openid")//对应表中的列
    private String id;

    @NotNull
    @Column(name = "user_name")
    private String name;

    @Column(name = "user_introduction")
    private String introduction;

    @Column(name = "user_tag")
    private String tag;

    @Column(name = "user_evaluateScore")
    private Double score;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
