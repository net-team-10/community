package com.zhouxiaosong.wx_class_project.dao;

import com.zhouxiaosong.wx_class_project.domain.UserQuestionMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface UserQuestionMapDAO extends JpaRepository<UserQuestionMap, Integer>, JpaSpecificationExecutor<UserQuestionMap>, Serializable {


    UserQuestionMap save(UserQuestionMap userQuestionMap);
}
