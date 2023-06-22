package com.elm.view;

import com.elm.pojo.Business;

public interface BusinessView {
    /**
     * 展示所有商家
     */
    public void listBusinessAll();

    /**
     * 按关键字展示商家
     */
    public void listBusinessByNameAndByAddress();

    /**
     * 新增商家
     */
    public void saveBusiness();

    /**
     * 删除商家
     */
    public void removeBusiness();

    /**
     * 商家登录
     * @return
     */
    public Business login();

    /**
     * 按id展示商家信息
     * @param businessId
     */
    public void showBusiness(Integer businessId);

    /**
     * 按id修改商家信息
     * @param businessId
     */
    public void editBusiness(Integer businessId);

    /**
     * 按id更新商家密码
     * @param businessId
     */
    public void updateBusinessPasswordByid(Integer businessId);

}
