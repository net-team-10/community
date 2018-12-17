package com.zhouxiaosong.wx_class_project.service;

import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.vo.AnswerForQuestion;

import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface QuestionService {

    Question getOneQuestion(int questionId);

    Question submitQuestion(Question question);

    List<Question> delQuestion(int questionId, int userId);

    Question controlQuestion(int questionId, int state);

    Question hideQuestion(int questionId);

    List<Question> listAllQuestions();

    List<Question> listUserSubmittedQuestions(int userId);

    List<AnswerForQuestion> listUserAnsweredQuestions(int userId);

    Question getQuestionById(int questionId);
}
