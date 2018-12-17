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
    public List<Comment> getAnswerComments(int answerId) {
        return commentDAO.findAllByAnswerId(answerId);
    }

    @Override
    public List<Comment> getCommentForUser(int userId) {
        List<Comment> comments = new ArrayList<>();
        //先找到自己有哪些回答
        //再找每一个回答的所有评论
        List<Answer> answers = answerDao.findAllByUserId(userId);
        for(Answer answer:answers){
            //自己的每一个回答
            List<Comment> answerComments = commentDAO.findAllByAnswerId(answer.getId());
            if(null!=answerComments&&answerComments.size()>0){
                Collections.sort(answerComments);
                comments.add(answerComments.get(0));
            }

        }
        return comments;
    }
}
