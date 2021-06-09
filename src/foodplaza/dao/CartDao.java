package foodplaza.dao;
import java.util.List;

import foodplaza.pojo.Cart;

public interface CartDao {

	boolean addToCart(Cart cart);
	boolean clearCart(String custEmail);
	boolean clearCart(String custEmail , int foodId);
	boolean deleteCart(int cartId);
	List<Cart> showCart(String custEmail);
	
}
