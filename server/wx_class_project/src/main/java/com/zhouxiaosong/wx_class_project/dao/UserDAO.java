package com.zhouxiaosong.wx_class_project.dao;

import com.zhouxiaosong.wx_class_project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>, Serializable {
    List<User> findAllByNickName(String nickName);

    @Transactional
    void deleteByNickName(String nickName);
    @Transactional
    User save(User user);

    User findById(int userId);



}
