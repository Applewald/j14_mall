package com.cskaoyan.mall.vo;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 21:56
 * @description
 */
public class ReVo {

    Data data;

    String errmsg;

    int errno;

    public ReVo() {
    }

    public ReVo(Data data, String errmsg, Integer errno) {
        this.data = data;
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }
}
