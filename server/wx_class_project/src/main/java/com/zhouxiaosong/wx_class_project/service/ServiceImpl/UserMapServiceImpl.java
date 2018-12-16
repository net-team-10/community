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
    public UserMap addFocusUser(String nickName, String focusNcikName) {
        UserMap userMap = new UserMap();
        List<User> users = userDao.findAllByNickName(nickName);
        User user = users.get(0);

        List<User> focusUsers = userDao.findAllByNickName(focusNcikName);
        User focusUser = focusUsers.get(0);

        userMap.setUser(user);
        userMap.setFocusedUser(focusUser);
        return userMapDao.save(userMap);

    }
}
