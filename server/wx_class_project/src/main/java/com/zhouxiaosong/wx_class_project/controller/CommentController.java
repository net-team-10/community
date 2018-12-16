package com.zhouxiaosong.wx_class_project.controller;

import com.zhouxiaosong.wx_class_project.domain.Answer;
import com.zhouxiaosong.wx_class_project.domain.Comment;
import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.AnswerServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.CommentServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.QuestionServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.UserServiceImpl;
import com.zhouxiaosong.wx_class_project.service.UserService;
import com.zhouxiaosong.wx_class_project.vo.CommentForAnswer;
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
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AnswerServiceImpl answerService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Comment submitComment(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        User user = userService.getUserByNickName(nickName);
        int answerId = Integer.parseInt(requestBody.get("answerId"));
        Answer answer = answerService.getAnswerById(answerId);
        String content = requestBody.get("content");
        String time = requestBody.get("time");
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setAnswer(answer);
        comment.setContent(content);
        comment.setTime(time);


        return commentService.submitComment(comment);
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public List<CommentForAnswer> getCommentForAnswer(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        return commentService.getCommentForAnswer(nickName);
    }

}
