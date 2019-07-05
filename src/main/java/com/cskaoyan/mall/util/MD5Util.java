package com.cskaoyan.mall.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-05 16:53
 * @description
 */
public class MD5Util {

    public static String getMD5(String string) throws NoSuchAlgorithmException {

        String result = "";

        // 加盐
        String temp = string + "j14";

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        byte[] digest = md5.digest(temp.getBytes());

        StringBuffer sb = new StringBuffer();

        for (byte b: digest) {
            int i = b&0x000000FE;
            String s1 = Integer.toHexString(i);
            if (s1.length()==1){
                sb.append("0");
            }
            sb.append(s1);
        }

        result = sb.toString();

        return result;
    }
}
