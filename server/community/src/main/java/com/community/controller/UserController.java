package com.community.controller;


import com.community.domain.User;
import com.community.repository.UserRepository;
import com.community.utils.Message;
import com.community.utils.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by PandaLin on 2018/12/8.
 */

@RestController
@RequestMapping("/user")
public class UserController {
    private transient UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{nickName}")
    public User getUserByNickName(@PathVariable("nickName") String nickName){

        List users = userRepository.findAllByNickName(nickName);
        if(users.size()==1){
            return (User)users.get(0);
        }
        User user = new User();
        user.setId(-1);
        return user;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody Map<String, String> requestBody){

        String nickName  = requestBody.get("nickName");
        String avatarUrl = requestBody.get("avatarUrl");
        int gender = Integer.parseInt(requestBody.get("gender"));
//        int state = Integer.parseInt(requestBody.get("state"));
        User existed = getUserByNickName(nickName);
        User vo = new User();
        if(existed.getId()!=-1){
            return existed;
        }

        vo.setAvatarUrl(avatarUrl);
        vo.setNickName(nickName);
        vo.setGender(gender);
//        user.setState(state);

        return userRepository.save(vo);

    }

}
