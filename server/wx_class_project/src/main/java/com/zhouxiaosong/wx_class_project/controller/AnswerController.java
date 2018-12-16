package com.zhouxiaosong.wx_class_project.controller;

import com.zhouxiaosong.wx_class_project.domain.Answer;
import com.zhouxiaosong.wx_class_project.domain.Comment;
import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.service.QuestionService;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.AnswerServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.QuestionServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.UserServiceImpl;
import com.zhouxiaosong.wx_class_project.vo.AnswerForQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */

@RestController
@RequestMapping(value = "/answer")
public class AnswerController {
    @Autowired
    private AnswerServiceImpl answerService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private QuestionServiceImpl questionService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Answer submitAnswer(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        User user = userService.getUserByNickName(nickName);
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        Question question = questionService.getQuestionById(questionId);
        String content = requestBody.get("content");
        String time = requestBody.get("time");
        int state = Integer.parseInt(requestBody.get("state"));
        Answer answer = new Answer();
        answer.setUser(user);
        answer.setQuestion(question);
        answer.setContent(content);
        answer.setHide(0);
        answer.setState(state);
        answer.setTime(time);
        return answerService.submitAnswer(answer);
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public List<Answer> listAnswersForQuestion(@RequestBody Map<String,String> requestBody){
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return answerService.listAllAnswersForQuestion(questionId);
    }



    @RequestMapping(value = "/user/focused", method = RequestMethod.POST)
    public List<AnswerForQuestion> getFocusedUserAnswers(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        return answerService.listFocusedUserAnswers(nickName);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Answer deleteAnswer(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        int answerId = Integer.parseInt(requestBody.get("answerId"));
        return answerService.delAnswer(nickName, answerId);
    }
}
