package com.cskaoyan.mall.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-04 15:21
 * @description
 */
public class IntArrayTypeHandler extends BaseTypeHandler<Integer[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Integer[] integers, JdbcType jdbcType) throws SQLException {
        if (integers.length == 0) {
            preparedStatement.setString(i, "[]");
        } else {
            StringBuffer stringBuffer = new StringBuffer("[");
            for (Integer integer : integers) {
                stringBuffer.append(integer).append(",");
            }
            String substring = stringBuffer.substring(0, stringBuffer.length() - 1) + "]";
            preparedStatement.setString(i, substring);
        }
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return string2IntArray(string);
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);

        return string2IntArray(string);
    }

    @Override
    public Integer[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return string2IntArray(string);
    }

    private Integer[] string2IntArray(String string) {
        // 为了去掉[]
        String substring = string.substring(1, string.length() - 1);
        if ("".equals(substring)) {
            return null;
        }
        String[] split = substring.split(",");

        Integer[] integers = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            integers[i] = Integer.valueOf(split[i]);
        }
        return integers;

    }
}
