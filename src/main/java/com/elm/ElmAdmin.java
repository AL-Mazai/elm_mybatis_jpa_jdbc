package com.elm;

import com.elm.pojo.Admin;
import com.elm.view.AdminView;
import com.elm.view.BusinessView;
import com.elm.view.impl.AdminViewImpl;
import com.elm.view.impl.BusinessViewImpl;

import java.util.Scanner;

public class ElmAdmin {
    public void work() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 饿了么后台管理系统 \t\t\t|");
        System.out.println("---------------------------------------------------------");

        AdminView adminView = new AdminViewImpl();
        BusinessView businessView = new BusinessViewImpl();
        Admin admin = adminView.login();

        //登录
        if (admin != null) {
            int menu = 0;
            while (menu != 5) {
                //输出主菜单
                System.out.println("\n========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
                System.out.println("请输入你的选择：");
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        businessView.listBusinessAll();
                        break;
                    case 2:
                        businessView.listBusinessByNameAndByAddress();
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        businessView.removeBusiness();
                        break;
                    case 5:
                        System.out.println("------------------------欢迎下次光临饿了么后台管理系统-----------------------");
                        break;
                    default:
                        System.out.println("没有这个选项！\n");
                        break;
                }
            }

        } else {
            System.out.println("\n管理员名称或密码输入错误!\n");
        }
    }

    public static void main(String[] args) {
        new ElmAdmin().work();
    }
}
