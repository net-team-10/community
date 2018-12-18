package com.zhouxiaosong.wx_class_project.service.ServiceImpl;

import com.zhouxiaosong.wx_class_project.dao.AdminDao;
import com.zhouxiaosong.wx_class_project.domain.Admin;
import com.zhouxiaosong.wx_class_project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public Admin addAdmin(Admin admin) {
        Admin ad = adminDao.findByNickName(admin.getNickName());
        if(null==ad){
            return adminDao.save(admin);
        }else{
            return ad;
        }
    }

    @Override
    public Admin findAdmin(int adminId) {
        return adminDao.findById(adminId);
    }
}
