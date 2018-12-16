package com.zhouxiaosong.wx_class_project.service;

import com.zhouxiaosong.wx_class_project.domain.UserQuestionMap;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface UserQuestionMapService {
    public UserQuestionMap focusQuestion(String nickName, int questionId);
}
