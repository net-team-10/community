package com.zhouxiaosong.wx_class_project.service.ServiceImpl;

import com.zhouxiaosong.wx_class_project.dao.AnswerDAO;
import com.zhouxiaosong.wx_class_project.dao.CommentDAO;
import com.zhouxiaosong.wx_class_project.dao.UserDAO;
import com.zhouxiaosong.wx_class_project.domain.Answer;
import com.zhouxiaosong.wx_class_project.domain.Comment;
import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.service.CommentService;
import com.zhouxiaosong.wx_class_project.vo.CommentForAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AnswerDAO answerDao;

    @Override
    public Comment submitComment(Comment comment) {
        return commentDAO.save(comment);
    }

    @Override
    public List<CommentForAnswer> getCommentForAnswer(String nickName) {
        List<User> users = userDao.findAllByNickName(nickName);
        User user = users.get(0);
        List<CommentForAnswer> commentForAnswers = new ArrayList<>();
        //先找到自己有哪些回答
        //再找每一个回答的所有评论
        List<Answer> answers = answerDao.findAllByUserId(user.getId());
        for(Answer answer:answers){
            //自己的每一个回答
            List<Comment> comments = commentDAO.findAllByAnswerId(answer.getId());
            for(Comment comment:comments){
                CommentForAnswer commentForAnswer = new CommentForAnswer();
                commentForAnswer.setComment(comment);
                commentForAnswer.setAnswer(comment.getAnswer());
                commentForAnswer.setUser(comment.getUser());
                commentForAnswer.setQuestion(comment.getAnswer().getQuestion());
                commentForAnswers.add(commentForAnswer);
            }
        }
        Collections.sort(commentForAnswers);
        return commentForAnswers;
    }
}
