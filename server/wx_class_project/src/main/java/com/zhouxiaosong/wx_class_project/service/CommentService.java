package com.zhouxiaosong.wx_class_project.service;

import com.zhouxiaosong.wx_class_project.domain.Comment;
import com.zhouxiaosong.wx_class_project.vo.CommentForAnswer;

import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface CommentService {
    public Comment submitComment(Comment comment);

    //查看对该用户的回答的所有评论，按时间倒排
    public List<Comment> getCommentForUser(int userId);

    public List<Comment> getAnswerComments(int answerId);

}
