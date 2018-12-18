package com.zhouxiaosong.wx_class_project.controller;

import com.zhouxiaosong.wx_class_project.domain.Admin;
import com.zhouxiaosong.wx_class_project.service.ServiceImpl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Admin addAdmin(@RequestBody Map<String,String> requestBody){
        String nickName = requestBody.get("nickName");
        String avatarUrl = requestBody.get("avatarUrl");
        Admin admin = new Admin();

        admin.setNickName(nickName);
        admin.setAvatarUrl(avatarUrl);
        return adminService.addAdmin(admin);
    }
}
