package com.cskaoyan.mall.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-04 17:09
 * @description
 */
public class BooleanTypeHandler extends BaseTypeHandler<Boolean> {

    // boolean --> int
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        int a = 0;
        if (aBoolean == true) {
            a = 1;
        } else {
            a = 0;
        }
        preparedStatement.setInt(i, a);
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int a = resultSet.getInt(s);

        return int2Boolean(a);
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int a = resultSet.getInt(i);
        return int2Boolean(a);
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int a = callableStatement.getInt(i);
        return int2Boolean(a);
    }

    private Boolean int2Boolean(int i) {
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }
}
