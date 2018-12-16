package com.zhouxiaosong.wx_class_project.utils;


public enum  Gender {
    UNK(0), MALE(1), FEMALE(2);

    private int gender;

    private Gender(int gender){
        this.gender = gender;
    }

    public int getGender(){
        return gender;
    }
}

