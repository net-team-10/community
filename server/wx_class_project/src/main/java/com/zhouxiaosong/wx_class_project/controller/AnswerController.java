package com.zhouxiaosong.wx_class_project.controller;

import com.zhouxiaosong.wx_class_project.domain.Answer;
import com.zhouxiaosong.wx_class_project.domain.Comment;
import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.service.QuestionService;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.AnswerServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.QuestionServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.UserMapServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.UserServiceImpl;
import com.zhouxiaosong.wx_class_project.service.UserMapService;
import com.zhouxiaosong.wx_class_project.vo.AnswerForQuestion;
import com.zhouxiaosong.wx_class_project.vo.AnswerVO;
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

    @Autowired
    private UserMapServiceImpl userMapService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Answer submitAnswer(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        User user = userService.getUserById(userId);
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

    @RequestMapping(value = "/user/submitted", method = RequestMethod.POST)
    public List<Answer> listUserAnswers(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        return answerService.listAllAnswersForUser(userId);
    }



    @RequestMapping(value = "/user/focused", method = RequestMethod.POST)
    public List<Answer> getFocusedUserAnswers(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        return answerService.listFocusedUserAnswers(userId);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Answer deleteAnswer(@RequestBody Map<String,String> requestBody){

        int answerId = Integer.parseInt(requestBody.get("answerId"));
        return answerService.delAnswer(answerId);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public AnswerVO getAnswer(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        int answerId = Integer.parseInt(requestBody.get("answerId"));
        Answer answer = answerService.getAnswerById(answerId);
        Boolean answererFocused = userMapService.checkUserFocused(userId, answer.getUser().getId());

        AnswerVO answerVO = new AnswerVO();
        answerVO.setAnswer(answer);
        answerVO.setAnswererFocused(answererFocused);

        return answerVO;

    }


}
