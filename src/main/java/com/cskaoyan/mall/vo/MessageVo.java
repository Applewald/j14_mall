package com.cskaoyan.mall.vo;

public class MessageVo {


    private int errno;
    private String errmsg;

    public MessageVo() {
    }


    public MessageVo(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
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

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public static MessageVo getSuccessMeg(){
        return new MessageVo(0,"成功");
    }

    public static MessageVo getFailMeg(){
        return new MessageVo(611,"商品名已经存在");
    }

}
