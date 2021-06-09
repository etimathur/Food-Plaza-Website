package foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import foodplaza.pojo.Customer;
import foodplaza.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao{

	int row;
	Connection con=DBUtility.getConnection();
	Customer cust;
	List<Customer> list;
	public boolean addCustomer(Customer cust) {
		
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into customer(custname,custemail,custpassword,custcontactno,custaddress) values(?,?,?,?,?)");
			ps.setString(1, cust.getCustName());
			ps.setString(2, cust.getCustEmail());
			ps.setString(3, cust.getCustPassword());
			ps.setLong(4, cust.getCustContactNo());
			ps.setString(5, cust.getCustAddress());
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
	public boolean deleteCustomerById(int custId) {
		try
		{
			PreparedStatement ps=con.prepareStatement("delete from customer where custId=?");
			ps.setLong(1, custId);
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
	
	public boolean deleteCustomerByEmail(String custEmail) {
		try
		{
			PreparedStatement ps=con.prepareStatement("delete from customer where custemail=?");
			ps.setString(1, custEmail);
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
	public boolean updateCustomerById(Customer cust) {
		try
		{
			
			PreparedStatement ps=con.prepareStatement("update customer set custname=?,custemail=?,custpassword=?,custcontactno=?,custaddress=? where custid=?");
			ps.setString(1, cust.getCustName());
			ps.setString(2, cust.getCustEmail());
			ps.setString(3, cust.getCustPassword());
			ps.setLong(4, cust.getCustContactNo());
			ps.setString(5, cust.getCustAddress());
			ps.setInt(6, cust.getCustId());
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
	public List<Customer> searchCustomerById(int custId) {
		try
		{
			list=new ArrayList<Customer>();
			PreparedStatement ps=con.prepareStatement("select * from customer where custid=?");
			ps.setInt(1,custId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				cust=new Customer(rs.getString("custname"),rs.getString("custemail"),rs.getString("custpassword"),rs.getString("custaddress"),rs.getLong("custcontactno"));
				cust.setCustId(custId);
				list.add(cust);
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		
		return list;
	}

	@Override
	public List<Customer> searchCustomerByEmail(String custEmail) {
		try
		{
			list=new ArrayList<Customer>();
			PreparedStatement ps=con.prepareStatement("select * from customer where custemail=?");
			ps.setString(1,custEmail);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				cust=new Customer(rs.getString("custname"),rs.getString("custemail"),rs.getString("custpassword"),rs.getString("custaddress"),rs.getLong("custcontactno"));
				cust.setCustId(rs.getInt("custid"));
				list.add(cust);
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		
		return list;
	}

	@Override
	public List<Customer> getAllCustomer() {
		try
		{
			list=new ArrayList<Customer>();
			PreparedStatement ps=con.prepareStatement("select * from customer");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				cust=new Customer(rs.getString("custname"),rs.getString("custemail"),rs.getString("custpassword"),rs.getString("custaddress"),rs.getLong("custcontactno"));
				cust.setCustId(rs.getInt("custId"));
				list.add(cust);
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		
		return list;
	}

}
