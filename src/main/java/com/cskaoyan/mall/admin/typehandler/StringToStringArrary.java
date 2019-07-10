package com.cskaoyan.mall.admin.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StringToStringArrary implements TypeHandler<String[]> {


    /*字符串数组 转换成 字符串： String[] ---> ["xxx", "xxx",...]*/
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {

        if ( strings == null || strings.length == 0 ){
            preparedStatement.setString(i,"[]");
        }else {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            for (int j = 0; j < strings.length; j++) {
                sb.append("\"");
                sb.append(strings[j]);
                sb.append("\"");
                if (j <strings.length-1){
                    sb.append(",");
                }
            }
            sb.append("]");
            preparedStatement.setString(i,sb.toString());
        }

    }

    /*字符串 转换成 字符串数组： ["xxx", "xxx",...] ---> String[] */
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
        if (s == null || "[]".equals(s)){
            return new String[0];
        }else {
            String substring = s.substring(1, s.length() - 1);
            String[] split = substring.split(",");

            List<String> stringLists = new ArrayList<>();
            /*for (String s1 : split) {
                String s2 = s1.substring(1, s1.length() - 1);
                stringLists.add(s2);
            }*/
            for (int i = 0; i < split.length; i++) {

                if (i==0) {
                    String substring1 = split[i].substring(1, split[i].length() - 1);
                    stringLists.add(substring1);
                } else {
                    String substring2 = split[i].substring(2, split[i].length() - 1);
                    stringLists.add(substring2);
                }
            }

            String[] strs1 = stringLists.toArray(new String[stringLists.size()]);

            return strs1;
        }

    }
}
