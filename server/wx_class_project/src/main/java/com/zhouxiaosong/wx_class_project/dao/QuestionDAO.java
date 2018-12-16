package com.zhouxiaosong.wx_class_project.dao;

import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface QuestionDAO extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question>, Serializable {

    @Transactional
    Question save(Question question);

    List<Question> findAllByUserId(int userId);

    @Transactional
    void deleteQuestionById(int id);

    Question findById(int id);



}
