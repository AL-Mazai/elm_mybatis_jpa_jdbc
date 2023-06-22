package com.elm.view;

import com.elm.pojo.Food;

import java.util.List;

public interface FoodView {
    /**
     * 按id展示商家的所有食品
     * @param businessId
     * @return
     */
    public List<Food> showFoodList(Integer businessId);

    /**
     * 按id增加商家的食品
     * @param businessId
     */
    public void saveFood(Integer businessId);

    /**
     * 按id更新商家的食品信息
     * @param businessId
     */
    public void updateFood(Integer businessId);

    /**
     * 按id删除商家的食品
     * @param businessId
     */
    public void removeFood(Integer businessId);
}
