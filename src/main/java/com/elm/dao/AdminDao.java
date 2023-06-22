package com.elm.dao;

import com.elm.pojo.Admin;

public interface AdminDao {
    /**
     * 根据姓名和密码查询admin
     * @param adminName
     * @param password
     * @return
     */
    public Admin getAdminByNameAndByPassword(String adminName, String password);

    /**
     * 根据id修改admin的密码
     * @param adminId
     * @param password
     * @return
     */
    public boolean updateAdminPasswordById(Integer adminId, String password);
}
