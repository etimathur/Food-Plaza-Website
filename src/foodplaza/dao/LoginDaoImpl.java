package foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import foodplaza.pojo.Login;
import foodplaza.utility.DBUtility;

public class LoginDaoImpl implements LoginDao {

	Connection con=DBUtility.getConnection();
	int row;
	Login login;
	
	@Override
	public boolean adminLogin(String email, String password) {
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from login where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		return false;
		
	}

	@Override
	public boolean customerLogin(String email, String password) {
		try {
			PreparedStatement ps=con.prepareStatement("select * from customer where custemail=? and custpassword=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		return false;
		}

	@Override
	public boolean changeAdminPassword(String email, String oldpassword, String newPassword) {
		try {
			PreparedStatement ps=con.prepareStatement("update login set password=? where email=? and password=?");
			ps.setString(1, newPassword);
			ps.setString(2, email);
			ps.setString(3, oldpassword);
			row=ps.executeUpdate();
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if (row>0)
			return true;
		
		return false;
	}

	@Override
	public boolean changeCustomerPassword(String email, String oldPassword, String newPassword) {
		try {
			PreparedStatement ps=con.prepareStatement("update customer set custpassword=? where custemail=? and custpassword=?");
			ps.setString(1, newPassword);
			ps.setString(2, email);
			ps.setString(3, oldPassword);
			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if (row>0)
			return true;
		
		return false;
	}

}
