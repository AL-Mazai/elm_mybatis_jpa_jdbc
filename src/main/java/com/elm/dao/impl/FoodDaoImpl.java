package com.elm.dao.impl;

import com.elm.dao.FoodDao;
import com.elm.pojo.Food;
import com.elm.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    //根据id查找food信息
    @Override
    public Food findFoodById(Integer foodId) {
        //获取EntityManager对象
        EntityManager manager = JPAUtil.getEntityManager();
        //执行方法
        Food food = manager.find(Food.class, foodId);
        //释放资源
        manager.close();
        return food;
    }

    //根据商家id查找所有对应商家的food
    @Override
    public List<Food> showFoodList(Integer businessId) {
        //获取EntityManager对象
        EntityManager manager = JPAUtil.getEntityManager();
        //定义HQL语句
        String hql = "select food from Food food where food.businessId = " + businessId;
        //创建HQL
        TypedQuery<Food> query = manager.createQuery(hql, Food.class);
        //执行SQL
        List<Food> foodList = query.getResultList();
        //释放资源
        manager.close();
        return foodList;
    }

    //新增food
    @Override
    public boolean saveFood(Food food) {
        //获取商家的食品列表
        List<Food> foodList = showFoodList(food.getBusinessId());
        String foodName = food.getFoodName();
        boolean isSave = true;
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        //判断所要增加的food是否已经存在
        for (Food f : foodList) {
            if (f.getFoodName().equals(foodName)) {
                isSave = false;
            }
        }
        //不存在则添加食品
        if (isSave) {
            manager.persist(food);
        }
        manager.getTransaction().commit();
        manager.close();
        return isSave;
    }

    //更新food信息
    @Override
    public boolean updateFood(Food food) {
        EntityManager manager = JPAUtil.getEntityManager();
        boolean isUpdate = false;
        manager.getTransaction().begin();
        if (manager.find(Food.class, food.getFoodId()) != null) {
            manager.merge(food);
            isUpdate = true;
        }
        manager.getTransaction().commit();
        manager.close();
        return isUpdate;
    }

    //根据id删除food
    @Override
    public boolean removeFood(Integer foodId) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        boolean isDel = false;
        //先找到id对应的food，再进行删除操作
        Food food = manager.find(Food.class, foodId);
        if (food != null) {
            manager.remove(food);
            isDel = true;
        }
        manager.getTransaction().commit();
        manager.close();
        return isDel;
    }
}
