package foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import foodplaza.pojo.Order;
import foodplaza.utility.DBUtility;

public class OrderDaoImpl implements OrderDao{

	int row;
	Connection con=DBUtility.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	Order order;
	List<Order> list;
	double totalBill;
	String orderStatus="processing";
	Date d=new Date();
	String date=d.toString(); 
	
	@Override
	public boolean placeOrder(String custEmail) {
		try
		{
			ps=con.prepareStatement("select sum(f.foodprice*c.foodquantity) from food f inner join cart c on f.foodid=c.foodid where custemail=?");
			ps.setString(1, custEmail);
			rs=ps.executeQuery();
			while(rs.next())
			{
				totalBill=rs.getDouble(1);
				ps=con.prepareStatement("insert into orders(custemailid,orderstatus,orderbill,orderdate) values(?,?,?,?)");
				ps.setString(1, custEmail);
				ps.setString(2, orderStatus);
				ps.setDouble(3, totalBill);
				ps.setString(4, date);
				row=ps.executeUpdate();
			}
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
	public boolean placeOrder(String custEmail, double totalBill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelOrder(int orderId) {
		try
		{
			ps=con.prepareStatement("update orders set orderstatus='cancelled' where orderid=?");
			ps.setInt(1,orderId );
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
	public List<Order> showOrder(String custEmail) {
		try
		{
			list=new ArrayList<Order>();
			ps=con.prepareStatement("select * from orders where custemailid=?");
			ps.setString(1,custEmail);
			rs=ps.executeQuery();
			while(rs.next())
			{
				order=new Order(rs.getString("custemailid"),rs.getString("orderstatus"),rs.getDouble("orderbill"),rs.getString("orderDate"));
				order.setOrderId(rs.getInt("orderId"));
				list.add(order);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> showAllOrder() {
		try
		{
			list=new ArrayList<Order>();
			ps=con.prepareStatement("select * from orders");
			rs=ps.executeQuery();
			while(rs.next())
			{
				order=new Order(rs.getString("custemailid"),rs.getString("orderstatus"),rs.getDouble("orderbill"),rs.getString("orderDate"));
				order.setOrderId(rs.getInt("orderId"));
				list.add(order);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	

}
