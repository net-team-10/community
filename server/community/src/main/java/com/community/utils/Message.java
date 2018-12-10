package com.community.utils;

/**
 * Created by PandaLin on 2018/12/10.
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
