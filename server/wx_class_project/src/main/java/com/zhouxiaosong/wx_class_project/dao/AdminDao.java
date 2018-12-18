package com.zhouxiaosong.wx_class_project.dao;

import com.zhouxiaosong.wx_class_project.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface AdminDao extends JpaRepository<Admin, Integer>, JpaSpecificationExecutor<Admin>, Serializable {

    Admin save(Admin admin);

    Admin findById(int id);

    Admin findByNickName(String nickName);
}
