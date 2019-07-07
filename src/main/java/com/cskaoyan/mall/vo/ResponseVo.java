package com.cskaoyan.mall.vo;

/**
 * author lixiaolong
 * date: 2019-07-03 15:03
 * description:
 */
public class ResponseVo<T> {
    private int errno;
    private T data;
    private String errmsg;

    public ResponseVo() {
    }

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

    public ResponseVo(int errno, T data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }
}
