package com.elm.dao;

import com.elm.pojo.Food;

import java.util.List;

public interface FoodDao {
    /**
     * 根据id查找food信息
     * @param foodId
     * @return
     */
    public Food findFoodById(Integer foodId);

    /**
     * 根据商家id查找所有对应商家的food
     * @param businessId
     * @return
     */
    public List<Food> showFoodList(Integer businessId);

    /**
     * 新增food
     * @param food
     * @return
     */
    public boolean saveFood(Food food);

    /**
     * 更新food信息
     * @param food
     * @return
     */
    public boolean updateFood(Food food);

    /**
     * 根据id删除food
     * @param foodId
     * @return
     */
    public boolean removeFood(Integer foodId);
}
