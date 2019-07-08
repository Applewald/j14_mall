package com.cskaoyan.mall.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-04 22:23
 * @description
 */
public class DateToStringTypeHandler extends BaseTypeHandler<String> {

    /* String ---> Date */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

    }


    /* Date ---> String*/
    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Date date = resultSet.getDate(s);
        return dateToString(date);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Date date = resultSet.getDate(i);
        return dateToString(date);
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Date date = callableStatement.getDate(i);
        return dateToString(date);
    }

    private String dateToString(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
