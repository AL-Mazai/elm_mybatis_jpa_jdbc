import com.elm.dao.FoodDao;
import com.elm.dao.impl.FoodDaoImpl;
import com.elm.pojo.Food;
import org.junit.Test;

import java.util.List;

public class JPAFoodTest {
    FoodDao foodDao = new FoodDaoImpl();
    @Test
    public void findFoodById(){
        int id = 111;
        Food food = foodDao.findFoodById(id);
        System.out.println(food);
    }
    @Test
    public void findFoodList(){
        Integer businessId = 10001;
        List<Food> foodList = foodDao.showFoodList(businessId);
        System.out.println(foodList);
    }
    @Test
    public void deleteFood(){
        int id = 6;
        boolean b = foodDao.removeFood(id);
        System.out.println(b);
    }
    @Test
    public void addFood(){
        Food food = new Food();
        food.setFoodName("1");
        food.setFoodExplain("1");
        food.setFoodPrice(12.5);
        food.setBusinessId(10003);
        foodDao.saveFood(food);
    }
    @Test
    public void updateFood(){
        Food food = new Food();
        food.setFoodId(6);
        food.setFoodName("火锅");
        food.setBusinessId(10005);
        food.setFoodPrice(13.3);
        boolean b = foodDao.updateFood(food);
        System.out.println(b);
    }
}
