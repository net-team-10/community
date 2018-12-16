package com.zhouxiaosong.wx_class_project.service;

import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.vo.AnswerForQuestion;

import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface QuestionService {

    Question submitQuestion(Question question);

    List<Question> delQuestion(int questionId, String userNickName);

    Question closeQuestion(int questionId);

    List<Question> listAllQuestions();

    List<Question> listUserSubmittedQuestions(String userNickName);

    List<AnswerForQuestion> listUserAnsweredQuestions(String userNickName);

    Question getQuestionById(int questionId);
}
