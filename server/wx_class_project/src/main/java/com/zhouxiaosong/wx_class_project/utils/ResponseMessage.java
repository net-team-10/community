package com.zhouxiaosong.wx_class_project.utils;

/**
 * Created by zhouxiaosong on 2018/12/15.
 */
public class ResponseMessage {
    private int msgcode;
    private Object obj;

    public ResponseMessage(int msgcode, Object obj) {
        this.msgcode = msgcode;
        this.obj = obj;
    }


    public int getMsgcode() {
        return msgcode;
    }

    public void setMsgcode(int msgcode) {
        this.msgcode = msgcode;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
