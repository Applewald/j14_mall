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
public class IntArrayTypeHandler2 extends BaseTypeHandler<int[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int index, int[] input, JdbcType jdbcType) throws SQLException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int value : input) {
            stringBuffer.append(value).append(",");
        }
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
        preparedStatement.setString(index, substring);
    }

    @Override
    public int[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return string2IntArray(string);
    }

    @Override
    public int[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);

        return string2IntArray(string);
    }

    @Override
    public int[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return string2IntArray(string);
    }

    private int[] string2IntArray(String string) {
        // 为了去掉[]
        String substring = string.substring(1, string.length() - 1);
        String[] split = substring.split(",");

        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.valueOf(split[i]);
        }
        return ints;
    }
}
