package com.zhouxiaosong.wx_class_project.controller;

import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.domain.UserMap;
import com.zhouxiaosong.wx_class_project.domain.UserQuestionMap;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.QuestionServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.UserMapServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.UserQuestionMapServiceImpl;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private UserMapServiceImpl userMapService;

    @Autowired
    private UserQuestionMapServiceImpl userQuestionMapService;

    @RequestMapping(value = "/{nickName}", method = RequestMethod.GET)
    public User getUserByNickName(@PathVariable String nickName){
        return userService.getUserByNickName(nickName);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User addUser(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        String avatarUrl = requestBody.get("avatarUrl");
        int gender = Integer.parseInt(requestBody.get("gender"));
        User user = new User();
        user.setAvatarUrl(avatarUrl);
        user.setNickName(nickName);
        user.setGender(gender);
        return userService.addUser(user);
    }


    /**
     * 查询用户列表方法
     */
    @RequestMapping(value ="/list", method = RequestMethod.GET)
    public List<User> list(){
        return userService.getUserList();
    }

    /**
     * 更新用户信息
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        String avatarUrl = requestBody.get("avatarUrl");
        int gender = Integer.parseInt(requestBody.get("gender"));
        User user = new User();
        user.setAvatarUrl(avatarUrl);
        user.setNickName(nickName);
        user.setGender(gender);
        return userService.updateUser(user);
    }

    /**
     * 删除用户
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public List<User> deleteUserByNickName(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        return userService.deleteUserByNickName(nickName);
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Question submitQuestion(@RequestBody Map<String, String> requestBody){
        String nickName = requestBody.get("nickName");
        String title = requestBody.get("title");
        String content = requestBody.get("content");
        String time = requestBody.get("time");
        int state = Integer.parseInt(requestBody.get("state"));
        User user = userService.getUserByNickName(nickName);
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        question.setTime(time);
        question.setState(state);
        question.setHide(0);
        question.setUser(user);
        return questionService.submitQuestion(question);
    }



    @RequestMapping(value = "/focus", method = RequestMethod.POST)
    public UserMap focusUser(@RequestBody Map<String, String> requestBody){
        String nickName = requestBody.get("nickName");
        String focusNickName = requestBody.get("focusNickName");
        return userMapService.addFocusUser(nickName,focusNickName);
    }


    @RequestMapping(value = "/question/focus", method = RequestMethod.POST)
    public UserQuestionMap focusQuestion(@RequestBody Map<String, String> requestBody){

        String nickName = requestBody.get("nickName");
        int questionId = Integer.parseInt(requestBody.get("questionId"));
        return userQuestionMapService.focusQuestion(nickName,questionId);
    }


}
