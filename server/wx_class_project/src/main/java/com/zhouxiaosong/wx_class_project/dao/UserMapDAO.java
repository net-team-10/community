package com.zhouxiaosong.wx_class_project.dao;

import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.domain.UserMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */

public interface UserMapDAO extends JpaRepository<UserMap,Integer>, JpaSpecificationExecutor<UserMap>, Serializable {

    @Transactional
    UserMap save(UserMap userMap);

    List<UserMap> getAllByUserId(int userId);

    List<UserMap> getAllByUserIdAndFocusedUserId(int userId, int focusedUserId);

    @Transactional
    void deleteUserMapByUserIdAndFocusedUserId(int userId, int focusedUserId);
}
