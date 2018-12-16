package com.zhouxiaosong.wx_class_project.dao;

import com.zhouxiaosong.wx_class_project.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface AnswerDAO extends JpaRepository<Answer, Integer>, JpaSpecificationExecutor<Answer>, Serializable {

    @Transactional
    Answer save(Answer answer);

    List<Answer> findAllByQuestionId(int questionId);

    List<Answer> findAllByUserId(int userId);

    Answer findById(int answerId);
}
