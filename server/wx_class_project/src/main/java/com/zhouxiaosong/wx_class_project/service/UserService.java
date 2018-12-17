package com.zhouxiaosong.wx_class_project.service;

import com.zhouxiaosong.wx_class_project.domain.User;

import java.util.List;

public interface UserService {

    User getUserByNickName(String nickName);

    User addUser(User user);

    List<User> getUserList();

    User updateUser(User user);

    List<User> deleteUserByNickName(String nickName);

    User getUserById(int userId);

}
