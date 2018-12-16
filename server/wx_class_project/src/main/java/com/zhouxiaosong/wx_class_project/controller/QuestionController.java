package com.zhouxiaosong.wx_class_project.controller;

import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.UserQuestionMap;
import com.zhouxiaosong.wx_class_project.service.QuestionService;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.QuestionServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.UserQuestionMapServiceImpl;
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
@RequestMapping(value = "/question")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private UserQuestionMapServiceImpl userQuestionMapService;


    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public List<Question> deleteQuestion(@RequestBody Map<String,String> requestBody){

        String nickName = requestBody.get("nickName");
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return questionService.delQuestion(questionId, nickName);
    }

    @RequestMapping(value = "/close", method = RequestMethod.POST)
    public Question closeQuestion(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return questionService.closeQuestion(questionId);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Question> getAllQuestions(){
        return questionService.listAllQuestions();
    }

    @RequestMapping(value = "/user/ask", method = RequestMethod.POST)
    public List<Question> listQuestionsForUser(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        return questionService.listUserSubmittedQuestions(nickName);
    }

    @RequestMapping(value = "/focus", method = RequestMethod.POST)
    public UserQuestionMap focusQuestion(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return userQuestionMapService.focusQuestion(nickName,questionId);
    }

    @RequestMapping(value = "/user/answer", method = RequestMethod.POST)
    public List<AnswerForQuestion> listAnswerForUser(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        return questionService.listUserAnsweredQuestions(nickName);
    }


}
