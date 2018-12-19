package com.zhouxiaosong.wx_class_project.service.ServiceImpl;

import com.zhouxiaosong.wx_class_project.dao.QuestionDAO;
import com.zhouxiaosong.wx_class_project.dao.UserDAO;
import com.zhouxiaosong.wx_class_project.dao.UserQuestionMapDAO;
import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.domain.UserQuestionMap;
import com.zhouxiaosong.wx_class_project.service.UserQuestionMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
@Service
public class UserQuestionMapServiceImpl implements UserQuestionMapService {
    @Autowired
    private UserQuestionMapDAO userQuestionMapDao;

    @Autowired
    private QuestionDAO questionDao;

    @Autowired
    private UserDAO userDao;


    @Override
    public UserQuestionMap focusQuestion(int userId, int questionId) {
        UserQuestionMap userQuestionMap = new UserQuestionMap();
        Question question = questionDao.findById(questionId);
        User user = userDao.findById(userId);
        userQuestionMap.setQuestion(question);
        userQuestionMap.setUser(user);
        return userQuestionMapDao.save(userQuestionMap);
    }

    @Override
    public void notFocusQuestion(int userId, int questionId) {
        userQuestionMapDao.deleteUserQuestionMapByUserIdAndQuestionId(userId,questionId);
    }

    @Override
    public Boolean checkFocus(int userId, int questionId) {
        List<UserQuestionMap> maps = userQuestionMapDao.findAllByUserIdAndQuestionId(userId, questionId);
        return maps.size()>0;
    }

    @Override
    public List<Question> userFocusedQuestions(int userId) {
        List<Question> questions = new ArrayList<>();
        List<UserQuestionMap> maps = userQuestionMapDao.findAllByUserId(userId);
        for(UserQuestionMap map: maps){
            Question question = map.getQuestion();
            if(question.getHide()==0){
                questions.add(question);
            }

        }

        return questions;
    }
}
