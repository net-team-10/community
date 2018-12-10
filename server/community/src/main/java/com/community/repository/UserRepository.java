package com.community.repository;

import com.community.VO.UserVO;
import com.community.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by PandaLin on 2018/12/8.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllById(int userId);

    List<User> findAllByNickName(String nickName);

    User save(User user);
}
