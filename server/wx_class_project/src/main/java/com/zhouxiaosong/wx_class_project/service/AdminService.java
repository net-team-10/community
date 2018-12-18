package com.zhouxiaosong.wx_class_project.service;

import com.zhouxiaosong.wx_class_project.domain.Admin;

public interface AdminService {

    Admin addAdmin(Admin admin);

    Admin findAdmin(int adminId);
}
