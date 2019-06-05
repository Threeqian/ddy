package com.courseproject.sport.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_info")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_openid")//对应表中的列
    private String id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_introduction")
    private String introduction;
    @Column(name = "user_tag")
    private String tag;
    @Column(name = "user_evaluateScore")
    private double score;

    public User() {
    }

    public User(String id, String name, String introduction, String tag, double score) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.tag = tag;
        this.score = score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
