package foodplaza.pojo;

public class Cart {
	
	private int cartId,foodId,foodQuantity;
	private String custEmail,foodName;
	private double foodPrice,totalprice;
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getFoodQuantity() {
		return foodQuantity;
	}
	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	
	public Cart(int cartId, int foodId, int foodQuantity, String custEmail, String foodName, double foodPrice, double totalprice) {
		super();
		this.cartId = cartId;
		this.foodId = foodId;
		this.foodQuantity = foodQuantity;
		this.custEmail = custEmail;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.totalprice=totalprice;
	}
	public Cart(int foodId, int foodQuantity, String custEmail) {
		super();
		//this.cartId = cartId;
		this.foodId = foodId;
		this.foodQuantity = foodQuantity;
		this.custEmail = custEmail;
		this.totalprice=totalprice;
	}
	public Cart(int foodId, int foodQuantity, String custEmail, String foodName, double foodPrice) {
		super();
		this.foodId = foodId;
		this.foodQuantity = foodQuantity;
		this.custEmail = custEmail;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", foodQuantity=" + foodQuantity + ", custEmail="
				+ custEmail + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", totalprice=" + totalprice
				+ "]";
	}
	
	
	

}
