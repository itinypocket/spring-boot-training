package com.songguoliang.model;

import java.io.Serializable;

/**
 * @Description 操作结果
 * @Author sgl
 * @Date 2018-04-12 13:43
 */
public class Result implements Serializable {

    public static final int SUCCESS = 1;
    public static final int FAILURE = -1;
    private static final long serialVersionUID = -1379216122470594325L;

    private boolean success = false;
    private String msg = "";
    private Object obj = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
