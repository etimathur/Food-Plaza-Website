package foodplaza.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import foodplaza.pojo.Food;
import foodplaza.utility.DBUtility;

public class FoodDaoImpl implements FoodDao
{

	int row;
	Connection con=DBUtility.getConnection();
	Food food;
	List<Food> list;
	public boolean addFood(Food food) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into food(foodname,foodtype,foodcategory,foodimage,fooddescription,foodprice) values (?,?,?,?,?,?)");
			ps.setString(1, food.getFoodName());
			ps.setString(2, food.getFoodType());
			ps.setString(3, food.getFoodCatergory());
			ps.setString(4, food.getFoodImage());
			ps.setString(5, food.getFoodDescription());
			ps.setDouble(6, food.getFoodPrice());
			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		if(row>0)
			return true;
		else
			return false;
		}

	@Override
	public boolean updateFood(Food food) {
		
		try
		{
			
			PreparedStatement ps=con.prepareStatement("update food set foodname=?,foodtype=?,foodcategory=?,foodimage=?,fooddescription=?, foodprice=? where foodid=?");
			ps.setString(1, food.getFoodName());
			ps.setString(2, food.getFoodType());
			ps.setString(3, food.getFoodCatergory());
			ps.setString(4, food.getFoodImage());
			ps.setString(5, food.getFoodDescription());
			ps.setDouble(6, food.getFoodPrice());
			ps.setInt(7, food.getFoodId());
			row=ps.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteFood(int foodId) {
		try
		{
			
			PreparedStatement ps=con.prepareStatement("delete from food where foodid=?");
			ps.setInt(1, foodId);
			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public Food searchFoodById(int foodId) {
		try
		{
			list=new ArrayList<Food>();
			PreparedStatement ps=con.prepareStatement("select * from food where foodid=?");
			ps.setInt(1, foodId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				food=new Food(rs.getString("foodname"),rs.getString("foodtype"),rs.getString("foodcategory"),rs.getString("foodimage"),rs.getString("fooddescription"),rs.getDouble("foodprice"));
				food.setFoodId(foodId);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		return food;
	}

	@Override
	public List<Food> searchFoodByName(String foodName) {
		try
		{
			list=new ArrayList<Food>();
			PreparedStatement ps=con.prepareStatement("select * from food where foodname=?");
			ps.setString(1, foodName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				food=new Food(rs.getString("foodname"),rs.getString("foodtype"),rs.getString("foodcategory"),rs.getString("foodimage"),rs.getString("fooddescription"),rs.getDouble("foodprice"));
				list.add(food);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
		
		
	}

	@Override
	public List<Food> searchFoodByType(String foodType) {
		try
		{
			list=new ArrayList<Food>();
			PreparedStatement ps=con.prepareStatement("select * from food where foodtype=?");
			ps.setString(1, foodType);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				food=new Food(rs.getString("foodname"),rs.getString("foodtype"),rs.getString("foodcategory"),rs.getString("foodimage"),rs.getString("fooddescription"),rs.getDouble("foodprice"));
				list.add(food);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<Food> searchFoodByCategory(String foodCategory) {
		try
		{
			list=new ArrayList<Food>();
			PreparedStatement ps=con.prepareStatement("select * from food where foodtype=?");
			ps.setString(1, foodCategory);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				food=new Food(rs.getString("foodname"),rs.getString("foodtype"),rs.getString("foodcategory"),rs.getString("foodimage"),rs.getString("fooddescription"),rs.getDouble("foodprice"));
				list.add(food);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<Food> getAllFood() {
		try
		{
			list=new ArrayList<Food>();
			PreparedStatement ps=con.prepareStatement("select * from food");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				food=new Food(rs.getString("foodname"),rs.getString("foodtype"),rs.getString("foodcategory"),rs.getString("foodimage"),rs.getString("fooddescription"),rs.getDouble("foodprice"));
				food.setFoodId(rs.getInt("foodid"));
				list.add(food);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
	
	return list;
	}

	
}
