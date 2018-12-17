package com.zhouxiaosong.wx_class_project.controller;

import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.UserQuestionMap;
import com.zhouxiaosong.wx_class_project.service.QuestionService;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.QuestionServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.UserQuestionMapServiceImpl;
import com.zhouxiaosong.wx_class_project.vo.AnswerForQuestion;
import com.zhouxiaosong.wx_class_project.vo.QuestionVO;
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
@RequestMapping(value = "/question")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private UserQuestionMapServiceImpl userQuestionMapService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Question getOneQuestion(@RequestBody Map<String,String> requestBody){
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return questionService.getOneQuestion(questionId);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Question hideOneQuestion(@RequestBody Map<String,String> requestBody){
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return questionService.hideQuestion(questionId);
    }

    @RequestMapping(value = "/close", method = RequestMethod.POST)
    public Question closeQuestion(@RequestBody Map<String,String> requestBody){
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return questionService.controlQuestion(questionId, 0);
    }

    @RequestMapping(value = "/open", method = RequestMethod.POST)
    public Question openQuestion(@RequestBody Map<String,String> requestBody){
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return questionService.controlQuestion(questionId, 1);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Question> getAllQuestions(){
        return questionService.listAllQuestions();
    }

    @RequestMapping(value = "/user/ask", method = RequestMethod.POST)
    public List<Question> listQuestionsForUser(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        return questionService.listUserSubmittedQuestions(userId);
    }

    @RequestMapping(value = "/focus", method = RequestMethod.POST)
    public UserQuestionMap focusQuestion(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return userQuestionMapService.focusQuestion(userId,questionId);
    }

    @RequestMapping(value = "/ignore", method = RequestMethod.POST)
    public void notFocusQuestion(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        userQuestionMapService.notFocusQuestion(userId,questionId);
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public QuestionVO checkFocusQuestion(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        int questionId = Integer.parseInt(requestBody.get("questionId"));

        Question question =questionService.getOneQuestion(questionId);
        Boolean isMyQuestion = false;
        if(question.getUser().getId()==userId){
            isMyQuestion = true;
        }
        Boolean focused =  userQuestionMapService.checkFocus(userId,questionId);

        QuestionVO questionVO = new QuestionVO();
        questionVO.setFocused(focused);
        questionVO.setMyQuestion(isMyQuestion);
        questionVO.setQuestion(question);

        return questionVO;
    }

    @RequestMapping(value = "/user/answer", method = RequestMethod.POST)
    public List<AnswerForQuestion> listAnswerForUser(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        return questionService.listUserAnsweredQuestions(userId);
    }

    @RequestMapping(value = "/focused", method = RequestMethod.POST)
    public List<Question> userFocusedQuestions(@RequestBody Map<String,String> requestBody){
        int userId = Integer.parseInt(requestBody.get("userId"));
        return userQuestionMapService.userFocusedQuestions(userId);
    }




}
