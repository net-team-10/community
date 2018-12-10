package com.community.utils;

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
