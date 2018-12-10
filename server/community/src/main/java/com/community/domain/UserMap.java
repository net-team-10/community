package com.community.domain;

import javax.persistence.*;

/**
 * Created by PandaLin on 2018/12/10.
 */
@Entity
@Table(name = "user_map")
public class UserMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User focusedUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFocusedUser() {
        return focusedUser;
    }

    public void setFocusedUser(User focusedUser) {
        this.focusedUser = focusedUser;
    }
}
