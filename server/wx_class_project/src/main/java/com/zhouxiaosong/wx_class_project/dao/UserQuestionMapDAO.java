package com.zhouxiaosong.wx_class_project.dao;

import com.zhouxiaosong.wx_class_project.domain.Question;
import com.zhouxiaosong.wx_class_project.domain.UserQuestionMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface UserQuestionMapDAO extends JpaRepository<UserQuestionMap, Integer>, JpaSpecificationExecutor<UserQuestionMap>, Serializable {


    UserQuestionMap save(UserQuestionMap userQuestionMap);

    @Transactional
    void deleteUserQuestionMapByUserIdAndQuestionId(int userId, int questionId);

    List<UserQuestionMap> findAllByUserIdAndQuestionId(int userId, int questionId);

    List<UserQuestionMap> findAllByUserId(int userId);
}
