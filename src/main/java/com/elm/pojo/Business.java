package com.elm.pojo;

import lombok.Data;

@Data
public class Business {

    private Integer businessId;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double starPrice;
    private Double deliveryPrice;

    @Override
    public String toString() {
        return "\n商家编号："+this.businessId+
                "\n商家名称："+this.businessName+
                "\n商家地址："+this.businessAddress+
                "\n商家介绍："+this.businessExplain+
                "\n起送费："+this.starPrice+"￥"+
                "\n配送费："+this.deliveryPrice+"￥" +"\n";
    }
}
