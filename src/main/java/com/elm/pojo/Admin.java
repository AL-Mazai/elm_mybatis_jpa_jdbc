package com.elm.pojo;

import lombok.*;

@Data
public class Admin {
    private Integer adminId;
    private String adminName;
    private String password;

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
