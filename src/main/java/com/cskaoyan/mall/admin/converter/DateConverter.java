package com.cskaoyan.mall.admin.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author : summer
 * date 2019/7/3 20:29
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(s);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }
}
