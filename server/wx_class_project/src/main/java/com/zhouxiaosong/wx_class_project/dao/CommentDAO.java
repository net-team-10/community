package com.zhouxiaosong.wx_class_project.dao;

import com.zhouxiaosong.wx_class_project.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface CommentDAO extends JpaRepository<Comment,Integer>, JpaSpecificationExecutor<Comment>, Serializable {

    @Transactional
    Comment save(Comment comment);

    List<Comment> findAllByAnswerId(int answerId);
}
