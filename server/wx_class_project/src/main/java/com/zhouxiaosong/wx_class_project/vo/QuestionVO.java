package com.zhouxiaosong.wx_class_project.vo;

import com.zhouxiaosong.wx_class_project.domain.Question;

/**
 * Created by PandaLin on 2018/12/16.
 */
public class QuestionVO {
    Question question;
    Boolean myQuestion;
    Boolean focused;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getMyQuestion() {
        return myQuestion;
    }

    public void setMyQuestion(Boolean myQuestion) {
        this.myQuestion = myQuestion;
    }

    public Boolean getFocused() {
        return focused;
    }

    public void setFocused(Boolean focused) {
        this.focused = focused;
    }
}
