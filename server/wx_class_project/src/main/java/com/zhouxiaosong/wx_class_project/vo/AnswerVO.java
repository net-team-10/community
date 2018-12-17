package com.zhouxiaosong.wx_class_project.vo;

import com.zhouxiaosong.wx_class_project.domain.Answer;

/**
 * Created by PandaLin on 2018/12/16.
 */
public class AnswerVO {
    Answer answer;
    Boolean answererFocused;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Boolean getAnswererFocused() {
        return answererFocused;
    }

    public void setAnswererFocused(Boolean answererFocused) {
        this.answererFocused = answererFocused;
    }
}
