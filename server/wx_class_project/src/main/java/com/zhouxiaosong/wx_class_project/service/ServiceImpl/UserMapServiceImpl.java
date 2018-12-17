package com.zhouxiaosong.wx_class_project.service.ServiceImpl;

import com.zhouxiaosong.wx_class_project.dao.UserDAO;
import com.zhouxiaosong.wx_class_project.dao.UserMapDAO;
import com.zhouxiaosong.wx_class_project.domain.User;
import com.zhouxiaosong.wx_class_project.domain.UserMap;
import com.zhouxiaosong.wx_class_project.service.UserMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
@Service
public class UserMapServiceImpl implements UserMapService {

    @Autowired
    private UserMapDAO userMapDao;

    @Autowired
    private UserDAO userDao;

    @Override
    public UserMap addFocusUser(int userId, int focusedUserId) {
        User user = userDao.findById(userId);
        User focused = userDao.findById(focusedUserId);
        UserMap userMap = new UserMap();
        userMap.setUser(user);
        userMap.setFocusedUser(focused);

        return userMapDao.save(userMap);
    }

    @Override
    public Boolean checkUserFocused(int userId, int focusedUserId) {
        List maps = userMapDao.getAllByUserIdAndFocusedUserId(userId,focusedUserId);
        return maps.size()>0;
    }

    @Override
    public void ignoreUser(int userId, int focusedUserId) {
        userMapDao.deleteUserMapByUserIdAndFocusedUserId(userId, focusedUserId);
    }


}
