package com.elm;

import com.elm.pojo.Admin;
import com.elm.pojo.Business;
import com.elm.view.AdminView;
import com.elm.view.BusinessView;
import com.elm.view.FoodView;
import com.elm.view.impl.AdminViewImpl;
import com.elm.view.impl.BusinessViewImpl;
import com.elm.view.impl.FoodViewImpl;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        AdminView adminView = new AdminViewImpl();
        Admin a = adminView.login();
        System.out.println(a);
    }
}
