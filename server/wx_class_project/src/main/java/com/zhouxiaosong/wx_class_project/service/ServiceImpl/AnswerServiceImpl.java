package com.zhouxiaosong.wx_class_project.service.ServiceImpl;

import com.zhouxiaosong.wx_class_project.dao.AnswerDAO;
import com.zhouxiaosong.wx_class_project.dao.UserDAO;
import com.zhouxiaosong.wx_class_project.dao.UserMapDAO;
import com.zhouxiaosong.wx_class_project.domain.Answer;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.domain.UserMap;
import com.zhouxiaosong.wx_class_project.service.AnswerService;
import com.zhouxiaosong.wx_class_project.vo.AnswerForQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AnswerDAO answerDao;

    @Autowired
    private UserMapDAO userMapDao;

    @Override
    public Answer submitAnswer(Answer answer) {
        //answer就需要判重了
        //这个判重在前端判
        return answerDao.save(answer);
    }

    @Override
    public List<Answer> listAllAnswersForQuestion(int questionId) {
        List<Answer> answers = answerDao.findAllByQuestionId(questionId);
        Collections.sort(answers);
        return answers;
    }

    @Override
    public List<AnswerForQuestion> listFocusedUserAnswers(String nickName) {
        List<User> users = userDAO.findAllByNickName(nickName);
        User user = users.get(0);
        List<UserMap> userMaps = userMapDao.getAllByUserId(user.getId());
        List<AnswerForQuestion> answerForQuestions = new ArrayList<>();
        for(UserMap userMap:userMaps){
//            AnswerForQuestion answerForQuestion = new AnswerForQuestion();
            //获取该用户关注的每一个人
            User focusedUser = userMap.getFocusedUser();
            List<Answer> answers = answerDao.findAllByUserId(focusedUser.getId());
            //对该用户关注的每一个人focusedUser,循环访问这个人所回答的所有问题
            for (Answer answer:answers){
                AnswerForQuestion answerForQuestion = new AnswerForQuestion();
                answerForQuestion.setAnswer(answer);
                answerForQuestion.setUser(focusedUser);
                answerForQuestion.setQuestion(answer.getQuestion());
                answerForQuestions.add(answerForQuestion);
            }
        }
        Collections.sort(answerForQuestions);
        return answerForQuestions;
    }

    @Override
    public Answer delAnswer(String nickName, int answerId) {
        Answer answer = answerDao.findById(answerId);
        answer.setHide(1);
        answerDao.save(answer);
        return answer;
//        answerDao.deleteById(answerId);
//        return listAllAnswersForUser(nickName);
    }

    @Override
    public List<Answer> listAllAnswersForUser(String nickName) {
        List<User> users = userDAO.findAllByNickName(nickName);
        User user = users.get(0);
        List<Answer> answers = answerDao.findAllByUserId(user.getId());
        Collections.sort(answers);
        return answers;
    }

    public Answer getAnswerById(int answerId){
        return answerDao.findById(answerId);
    }
}
