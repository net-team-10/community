package com.zhouxiaosong.wx_class_project.service;

import com.zhouxiaosong.wx_class_project.domain.Answer;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.domain.UserMap;

import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public interface UserMapService {

    //新增关注用户
    UserMap addFocusUser(int userId, int focusedUserId);

    Boolean checkUserFocused(int userId, int focusedUserId);

    void ignoreUser(int userId, int focusedUserId);

}
