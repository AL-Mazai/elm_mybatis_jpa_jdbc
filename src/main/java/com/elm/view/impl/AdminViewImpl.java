package com.elm.view.impl;

import com.elm.dao.AdminDao;
import com.elm.dao.impl.AdminDaoImpl;
import com.elm.pojo.Admin;
import com.elm.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {
    private Scanner scanner = new Scanner(System.in);
    private AdminDao adminDao = new AdminDaoImpl();
    //管理员登录
    @Override
    public Admin login() {
        System.out.println("请输入管理员名称：");
        String adminName = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();

        return adminDao.getAdminByNameAndByPassword(adminName, password);
    }
}
