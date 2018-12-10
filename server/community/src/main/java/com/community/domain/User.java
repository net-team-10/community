package com.community.domain;

import com.community.utils.Gender;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by PandaLin on 2018/12/8.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nickName;

    private String avatarUrl;

    private int gender;

//    private int state;

    public int getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getState() {
//        return state;
//    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

//    public void setState(int state) {
//        this.state = state;
//    }
}
