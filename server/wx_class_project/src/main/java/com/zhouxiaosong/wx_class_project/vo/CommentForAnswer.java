package com.zhouxiaosong.wx_class_project.vo;

import com.zhouxiaosong.wx_class_project.domain.Answer;
import com.zhouxiaosong.wx_class_project.domain.Comment;
import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public class CommentForAnswer implements Comparable<CommentForAnswer>{

    private User user;

    private Question question;

    private Answer answer;

    private Comment comment;

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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public int compareTo(CommentForAnswer o) {
        return o.getComment().getTime().compareTo(this.getComment().getTime());
    }
}
