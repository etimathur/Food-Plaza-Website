package foodplaza.dao;

import java.util.List;

import foodplaza.pojo.Order;

public interface OrderDao {

	boolean placeOrder(String custEmail);
	boolean placeOrder(String custEmail,double totalBill);
	boolean cancelOrder(int orderId);
	List<Order> showOrder(String custEmail);
	List<Order> showAllOrder();
}
