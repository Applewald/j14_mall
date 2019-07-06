package com.cskaoyan.mall.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringToStringArrary implements TypeHandler<String[]> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {

        if ( strings == null || strings.length == 0 ){
            preparedStatement.setString(i,"[]");
        }else {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            for (int j = 0; j < strings.length; j++) {
                sb.append(strings[j]);
                if (j <strings.length-1){
                    sb.append(",");
                }
            }
            sb.append("]");
            preparedStatement.setString(i,sb.toString());
        }

    }

    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return StringTranferStringArrary(string);
    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return StringTranferStringArrary(string);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return StringTranferStringArrary(string);
    }

    private String[]  StringTranferStringArrary(String s){
        String substring = s.substring(1, s.length() - 1);
        return substring.split(",");
    }
}
