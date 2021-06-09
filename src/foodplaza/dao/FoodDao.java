package foodplaza.dao;

import java.util.List;

import foodplaza.pojo.Food;

public interface FoodDao {

	boolean addFood(Food food);
	boolean updateFood(Food food);
	boolean deleteFood(int foodId);
	Food searchFoodById(int foodId);
	List<Food> searchFoodByName(String foodName);
	List<Food> searchFoodByType(String foodType);
	List<Food> searchFoodByCategory(String foodCategory);
	List<Food> getAllFood();
	
	
}
