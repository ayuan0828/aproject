package com.example.aproject.beans;

/**
 * 前端控制器访问的信息封装类
 */
public class HttpResponseEntity {

    //状态码  eg:200 404
    private String code;
    // 内容
    private Object data;
    // 状态消息
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
