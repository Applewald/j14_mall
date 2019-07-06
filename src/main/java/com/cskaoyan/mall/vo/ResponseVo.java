package com.cskaoyan.mall.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author lixiaolong
 * date: 2019-07-03 15:03
 * description:
 */
public class ResponseVo<T> {
    private int errno;
    private T data;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }


    public String getErrmsg() {
        return errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public static Object ok(){
        Map<String, Object> o = new HashMap<>();
        o.put("errmsg", "成功");
        o.put("errno", 0);
        return o;
    }

    public static Object ok(Object data){
        ResponseVo<Object> responseVo = new ResponseVo<>();
        responseVo.setData(data);
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

    public static Object fail(String errmsg, Integer errno){
        Map<String, Object> o = new HashMap<>();
        o.put("errmsg", errmsg);
        o.put("errno", errno);
        return o;
    }
}
