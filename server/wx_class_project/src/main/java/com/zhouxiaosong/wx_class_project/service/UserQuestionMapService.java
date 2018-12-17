package com.zhouxiaosong.wx_class_project.service;

import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.UserQuestionMap;

import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface UserQuestionMapService {
    public UserQuestionMap focusQuestion(int userId, int questionId);

    public void notFocusQuestion(int userId, int questionId);

    public Boolean checkFocus(int userId, int questionId);

    List<Question> userFocusedQuestions(int userId);
}
