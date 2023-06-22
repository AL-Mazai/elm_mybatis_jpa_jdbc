package com.elm.util;

import java.sql.*;

public class JDBCUtil {
    //创建连接的方法
    public static Connection getConnection(){
        Connection conn = null;
        try{
            //使用反射获取driver加载驱动
            Class.forName(JDBCConfigUtil.getProp("driverClass"));
            //建立连接
            conn = DriverManager.getConnection(
                    JDBCConfigUtil.getProp("url"),
                    JDBCConfigUtil.getProp("user"),
                    JDBCConfigUtil.getProp("password"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //释放资源
    public static void closeConnection(ResultSet rs, PreparedStatement pst, Connection con){
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(pst != null){
            try{
                pst.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(con != null){
            try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
