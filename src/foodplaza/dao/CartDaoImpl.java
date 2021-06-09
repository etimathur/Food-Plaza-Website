package foodplaza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import foodplaza.pojo.Cart;
import foodplaza.utility.DBUtility;

public class CartDaoImpl implements CartDao{

	int row;
	Connection con=DBUtility.getConnection();
	Cart cart;
	List<Cart> list;
	public boolean addToCart(Cart cart) {
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into cart(foodid,custemail,foodquantity,totalprice) values (?,?,?,?)");
			ps.setInt(1,cart.getFoodId());
			ps.setString(2, cart.getCustEmail());
			ps.setInt(3, cart.getFoodQuantity());
			double price= cart.getFoodPrice()*cart.getFoodQuantity();
			cart.setTotalprice(price);
			ps.setDouble(4,price);
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

	public boolean clearCart(String custEmail) {
		try
		{
			PreparedStatement ps=con.prepareStatement("delete from cart where custemail=?");
			ps.setString(1,custEmail);
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
	public boolean clearCart(String custEmail, int foodId) {
		try
		{
			PreparedStatement ps=con.prepareStatement("delete from cart where custemail=? AND foodid=?");
			ps.setString(1,custEmail);
			ps.setInt(2, foodId);
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
	public List<Cart> showCart(String custEmail) {
		try
		{
			list=new ArrayList<Cart>();
			System.out.println("Before from daao"+list);
			PreparedStatement ps=con.prepareStatement("select c.cartid,c.foodid,f.foodname,c.custemail,c.foodquantity,f.foodprice,c.totalprice from food f inner join cart c on f.foodid=c.foodid and c.custemail=?");
			ps.setString(1, custEmail);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				cart=new Cart(rs.getInt("cartid"),rs.getInt("foodid"),rs.getInt("foodquantity"),rs.getString("custemail"),rs.getString("foodname"),rs.getDouble("foodprice"),rs.getDouble("totalprice"));
				
				list.add(cart);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("List from daao"+list);
		
		return list;
	}

	@Override
	public boolean deleteCart(int cartId) {
		try
		{
			PreparedStatement ps=con.prepareStatement("delete from cart where cartId=?");
			ps.setInt(1,cartId);
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

	

}
