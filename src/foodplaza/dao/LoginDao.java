package foodplaza.dao;

public interface LoginDao {

	boolean adminLogin(String email,String password);
	boolean customerLogin(String email,String password);
	boolean changeAdminPassword(String email,String oldpassword,String newPassword);
	boolean changeCustomerPassword(String email,String oldPassword,String newPassword);
}
