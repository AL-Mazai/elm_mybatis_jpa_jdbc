package com.elm.dao.impl;

import com.elm.dao.AdminDao;
import com.elm.pojo.Admin;
import com.elm.util.JDBCUtil;
import org.apache.ibatis.jdbc.SQL;

import java.sql.*;

public class AdminDaoImpl implements AdminDao {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    //根据姓名和密码查询admin
    @Override
    public Admin getAdminByNameAndByPassword(String adminName, String password) {
        Admin admin = new Admin();
        //定义sql
        String sql = "select * from admin where adminName = ? and password = ?";
        try{
            //获取连接
            conn = JDBCUtil.getConnection();
            //预处理sql
            pst =  conn.prepareStatement(sql);
            //占位符赋值
            pst.setString(1, adminName);
            pst.setString(2, password);
            //执行sql并存储结果集到rs中
            rs = pst.executeQuery();
            //使rs指向结果集的第一行数据
            rs.next();
            //获取第一行的每一列值
            admin.setAdminId(rs.getInt("adminId"));
            admin.setAdminName(rs.getString("adminName"));
            admin.setPassword(rs.getString("password"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtil.closeConnection(rs, pst, conn);
        }
        return admin;
    }

    //根据id修改admin的密码
    @Override
    public boolean updateAdminPasswordById(Integer adminId, String password) {
        String sql = "update admin set password = ? where adminId = ?";
        boolean isUpdate = false;
        try{
            conn = JDBCUtil.getConnection();
            //禁用自动提交
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setString(1, password);
            pst.setInt(2, adminId);
            isUpdate = pst.executeUpdate() > 0 ? true : false;
//            int i = 1/0;//设置异常
            //提交事务
            conn.commit();
        }catch (SQLException e){
            // 回滚事务
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(rs, pst, conn);
        }
        return isUpdate;
    }
}
