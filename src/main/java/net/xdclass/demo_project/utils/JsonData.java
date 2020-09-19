package net.xdclass.demo_project.utils;

/**
 * @ClassName : JsonData  //类名
 * @Description : 接口返回工具类  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-19 19:46  //时间
 */
public class JsonData {
    private int code;
    private Object data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonData() {
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static JsonData buildSuccess(Object data) {
        return  new JsonData(0,data);
    }
    public static JsonData buildError(String msg) {
        return  new JsonData(-1,"",msg);
    }
    public static JsonData buildError(int code,String msg) {
        return  new JsonData(code,"",msg);
    }
}