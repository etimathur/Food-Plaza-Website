package foodplaza.dao;
import java.util.List;

import foodplaza.pojo.Customer;

public interface CustomerDao {

	boolean addCustomer(Customer cust);
	boolean deleteCustomerById(int custId);
	boolean deleteCustomerByEmail(String custEmail);
	boolean updateCustomerById(Customer cust);
	List<Customer> searchCustomerById(int custd);
	List<Customer> searchCustomerByEmail(String custd);
	List<Customer> getAllCustomer();
}
