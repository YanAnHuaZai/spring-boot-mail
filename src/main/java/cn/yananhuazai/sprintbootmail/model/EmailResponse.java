package cn.yananhuazai.sprintbootmail.model;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-06 10:49
 **/
public class EmailResponse {
    private Integer code; //状态码
    private String msg; //消息
    private Object obj;

    public EmailResponse() {
    }

    public EmailResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public EmailResponse(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
