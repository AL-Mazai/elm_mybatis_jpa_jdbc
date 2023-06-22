package com.elm.view.impl;

import com.elm.mapper.BusinessMapper;
import com.elm.mapper.impl.BusinessMapperImpl;
import com.elm.pojo.Business;
import com.elm.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    private Scanner scanner = new Scanner(System.in);
    private BusinessMapper businessMapper = new BusinessMapperImpl();

    //展示所有商家
    @Override
    public void listBusinessAll() {
        //xml里使用的是模糊查询，所以这里两个参数都设为null，就可以获得所有商家信息
        List<Business> list = businessMapper.getBusinessList(null, null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t"
                    + b.getBusinessExplain() + "\t" + b.getStarPrice() + "\t" + b.getDeliveryPrice());
        }
    }

    //按关键字展示商家
    @Override
    public void listBusinessByNameAndByAddress() {
        String businessName = "";
        String businessAddress = "";
        String inputStr = "";

        System.out.println("是否需要输入商家名称关键词(y/n)：");
        inputStr = scanner.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家名称关键词：");
            businessName = scanner.next();
        }

        System.out.println("是否需要输入商家地址关键词(y/n)：");
        inputStr = scanner.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家地址关键词：");
            businessAddress = scanner.next();
        }

        List<Business> list = businessMapper.getBusinessList(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t"
                    + b.getBusinessExplain() + "\t" + b.getStarPrice() + "\t" + b.getDeliveryPrice());
        }
    }

    //新增商家
    @Override
    public void saveBusiness() {
        Business business = new Business();

        System.out.println("请输入商家名称：");
        business.setBusinessName(scanner.next());
        System.out.println("请输入商家密码：");
        business.setPassword(scanner.next());
        System.out.println("请输入商家地址：");
        business.setBusinessAddress(scanner.next());
        System.out.println("请输入商家介绍：");
        business.setBusinessExplain(scanner.next());
        System.out.println("请输入商家起送费：");
        business.setStarPrice(scanner.nextDouble());
        System.out.println("请输入商家配送费：");
        business.setDeliveryPrice(scanner.nextDouble());

        int businessId = businessMapper.saveBusiness(business);
        if (businessId > 0) {
            System.out.println("新建商家成功！商家编号为：" + businessId);
        } else {
            System.out.println("新建商家失败！");
        }
    }

    //删除商家
    @Override
    public void removeBusiness() {
        System.out.println("请输入商家编号：");
        int businessId = scanner.nextInt();

        System.out.println("确认要删除吗(y/n)：");
        if (scanner.next().equals("y")) {
            boolean result = businessMapper.removeBusiness(businessId);
            if (result) {
                System.out.println("删除商家成功！");
            } else {
                System.out.println("删除商家失败！");
            }
        }
    }

    //商家登录
    @Override
    public Business login() {
        System.out.println("请输入商家编号：");
        int businessId = scanner.nextInt();
        System.out.println("请输入密码：");
        String password = scanner.next();

        return businessMapper.getBusinessByIdAndByPassword(businessId, password);
    }

    //按id展示商家信息
    @Override
    public void showBusiness(Integer businessId) {
        Business business = businessMapper.getBusinessById(businessId);
        System.out.println(business);
    }

    //按id修改商家信息
    @Override
    public void editBusiness(Integer businessId) {
        //先将商家信息查询出来显示，然后用户才能更新
        Business business = businessMapper.getBusinessById(businessId);
        System.out.println(business);

        String inputStr = "";
        System.out.println("是否修改商家名称(y/n)：");
        inputStr = scanner.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家名称：");
            business.setBusinessName(scanner.next());
        }

        System.out.println("是否修改商家地址(y/n)：");
        inputStr = scanner.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家地址：");
            business.setBusinessAddress(scanner.next());
        }

        System.out.println("是否修改商家介绍(y/n)：");
        inputStr = scanner.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家介绍：");
            business.setBusinessExplain(scanner.next());
        }

        System.out.println("是否修改起送费(y/n)：");
        inputStr = scanner.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的起送费：");
            business.setStarPrice(scanner.nextDouble());
        }

        System.out.println("是否修改配送费(y/n)：");
        inputStr = scanner.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的配送费：");
            business.setDeliveryPrice(scanner.nextDouble());
        }

        boolean result = businessMapper.updateBusiness(business);
        if (result) {
            System.out.println("\n修改商家信息成功！\n");
        } else {
            System.out.println("\n修改商家信息失败！\n");
        }
    }

    //按id更新商家密码
    @Override
    public void updateBusinessPasswordByid(Integer businessId) {
        Business business = businessMapper.getBusinessById(businessId);

        System.out.println("\n请输入旧密码：");
        String oldPass = scanner.next();
        System.out.println("\n请输入新密码：");
        String password = scanner.next();
        System.out.println("\n请再次输入新密码：");
        String beginPassword = scanner.next();

        if (!business.getPassword().equals(oldPass)) {
            System.out.println("\n旧密码输入错误！");
        } else if (!password.equals(beginPassword)) {
            System.out.println("\n两次输入密码不一致！");
        } else {
            boolean result = businessMapper.updateBusinessPasswordById(businessId, password);
            if (result) {
                System.out.println("\n修改密码成功！");
            } else {
                System.out.println("\n修改密码失败！");
            }
        }
    }
}
