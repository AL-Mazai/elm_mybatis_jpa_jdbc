package com.elm.view.impl;

import com.elm.dao.FoodDao;
import com.elm.dao.impl.FoodDaoImpl;
import com.elm.pojo.Food;
import com.elm.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    private Scanner scanner = new Scanner(System.in);
    private FoodDao foodDao = new FoodDaoImpl();

    //按id展示商家的所有食品
    @Override
    public List<Food> showFoodList(Integer businessId) {
        List<Food> list = foodDao.showFoodList(businessId);
        System.out.println("食品编号\t食品名称\t食品介绍\t食品价格");
        for (Food food : list) {
            System.out.println(food.getFoodId() + "\t" + food.getFoodName() + "\t"
                    + food.getFoodExplain() + "\t" + food.getFoodPrice());
        }
        return list;
    }

    //按id增加商家的食品
    @Override
    public void saveFood(Integer businessId) {
        Food food = new Food();
        System.out.println("请输入食品名称：");
        food.setFoodName(scanner.next());
        System.out.println("请输入食品介绍：");
        food.setFoodExplain(scanner.next());
        System.out.println("请输入食品价格：");
        food.setFoodPrice(scanner.nextDouble());
        food.setBusinessId(businessId);

        boolean result = foodDao.saveFood(food);
        if (result) {
            System.out.println("\n新增食品成功！\n");
        } else {
            System.out.println("\n食品已存在，无法重复添加食品！\n");
        }
    }

    //按id更新商家的食品信息
    @Override
    public void updateFood(Integer businessId) {
        List<Food> list = showFoodList(businessId);

        if (list.size() == 0) {
            System.out.println("没有任何食品！");
        } else {
            System.out.println("请选择要更新的食品编号：");
            int foodId = scanner.nextInt();
            Food food = foodDao.findFoodById(foodId);
            System.out.println(food);

            String inputStr = "";
            System.out.println("是否更新食品名称(y/n)：");
            inputStr = scanner.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品名称：");
                food.setFoodName(scanner.next());
            }

            System.out.println("是否更新食品介绍(y/n)：");
            inputStr = scanner.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品介绍：");
                food.setFoodExplain(scanner.next());
            }

            System.out.println("是否更新食品价格(y/n)：");
            inputStr = scanner.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品价格：");
                food.setFoodPrice(scanner.nextDouble());
            }

            boolean result = foodDao.updateFood(food);
            if (result) {
                System.out.println("\n修改食品成功！\n");
            } else {
                System.out.println("\n修改食品失败！\n");
            }
        }
    }

    //按id删除商家的食品
    @Override
    public void removeFood(Integer businessId) {
        List<Food> list = showFoodList(businessId);

        if (list.size() == 0) {
            System.out.println("没有任何食品！");
        } else {
            System.out.println("请选择要删除的食品编号：");
            int foodId = scanner.nextInt();

            System.out.println("确认要删除吗(y/n)：");
            if (scanner.next().equals("y")) {
                boolean result = foodDao.removeFood(foodId);
                if (result) {
                    System.out.println("\n删除食品成功！\n");
                } else {
                    System.out.println("\n删除食品失败！\n");
                }
            }
        }
    }
}
