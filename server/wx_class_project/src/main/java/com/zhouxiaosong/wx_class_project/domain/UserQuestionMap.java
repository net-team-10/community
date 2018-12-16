package com.zhouxiaosong.wx_class_project.domain;

import javax.persistence.*;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
@Entity
@Table(name = "user_question_map")
public class UserQuestionMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Question question;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
