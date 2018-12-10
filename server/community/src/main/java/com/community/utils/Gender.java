package com.community.utils;

/**
 * Created by PandaLin on 2018/12/8.
 */
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
