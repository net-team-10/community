package com.zhouxiaosong.wx_class_project.utils;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public enum Message {
    SUCCESS("Succeed"),
    EXISTED("Existed"),
    NOTFOUND("Not Found");

    private String msg;
    private Message(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}