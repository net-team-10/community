package com.zhouxiaosong.wx_class_project.service.ServiceImpl;

import com.zhouxiaosong.wx_class_project.dao.AnswerDAO;
import com.zhouxiaosong.wx_class_project.dao.QuestionDAO;
import com.zhouxiaosong.wx_class_project.dao.UserDAO;
import com.zhouxiaosong.wx_class_project.domain.Answer;
import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.service.QuestionService;
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
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AnswerDAO answerDao;

    @Override
    public Question submitQuestion(Question question) {
        //这边不判断去重
        return questionDao.save(question);
    }

    @Override
    public List<Question> delQuestion(int questionId, String userNickName) {
        questionDao.deleteQuestionById(questionId);
        return listUserSubmittedQuestions(userNickName);
    }

    @Override
    public Question closeQuestion(int questionId) {
        Question question = questionDao.findById(questionId);
        if(question!=null){
            question.setHide(1);
            return questionDao.save(question);
        }
        //没有找到
        Question default_question = new Question();
        default_question.setId(-1);
        return default_question;
    }

    @Override
    public List<Question> listAllQuestions() {
        List<Question> questions = questionDao.findAll();
        Collections.sort(questions);
        return questions;
    }

    @Override
    public List<Question> listUserSubmittedQuestions(String userNickName) {
        List<User> users = userDao.findAllByNickName(userNickName);
        User user = users.get(0);
        List<Question> questions = questionDao.findAllByUserId(user.getId());
        //按时间顺序倒排
        Collections.sort(questions);
        return questions;
    }

    @Override
    public List<AnswerForQuestion> listUserAnsweredQuestions(String userNickName) {
        List<User> users = userDao.findAllByNickName(userNickName);
        User user = users.get(0);
        List<Answer> answers = answerDao.findAllByUserId(user.getId());
        Collections.sort(answers);

        List<AnswerForQuestion> answerForQuestions = new ArrayList<>();
        for(Answer answer:answers){
            AnswerForQuestion answerForQuestion = new AnswerForQuestion();
            answerForQuestion.setUser(answer.getUser());
            answerForQuestion.setAnswer(answer);
            answerForQuestion.setQuestion(answer.getQuestion());
            answerForQuestions.add(answerForQuestion);
        }
        return answerForQuestions;
    }

    @Override
    public Question getQuestionById(int questionId) {
        return questionDao.findById(questionId);
    }
}
