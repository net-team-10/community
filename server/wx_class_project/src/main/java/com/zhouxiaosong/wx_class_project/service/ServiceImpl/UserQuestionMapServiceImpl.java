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
    public UserQuestionMap focusQuestion(String nickName, int questionId) {
        List<User> users = userDao.findAllByNickName(nickName);
        User user = users.get(0);
        Question question = questionDao.findById(questionId);

        UserQuestionMap userQuestionMap = new UserQuestionMap();
        userQuestionMap.setUser(user);
        userQuestionMap.setQuestion(question);

        return userQuestionMapDao.save(userQuestionMap);
    }
}
