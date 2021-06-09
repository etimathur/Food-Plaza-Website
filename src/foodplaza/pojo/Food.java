package foodplaza.pojo;

public class Food {
	
	private int foodId;
	private String foodName;
	private String foodType;
	private String foodCategory;
	private String foodImage;
	private String foodDescription;
	private double foodPrice;
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodCatergory() {
		return foodCategory;
	}
	public void setFoodCatergory(String foodCatergory) {
		this.foodCategory = foodCatergory;
	}
	public String getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}
	public String getFoodDescription() {
		return foodDescription;
	}
	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public Food(String foodName, String foodType, String foodCategory, String foodImage,
			String foodDescription, double foodPrice) {
		super();
		//this.foodId = foodId;
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodCategory = foodCategory;
		this.foodImage = foodImage;
		this.foodDescription = foodDescription;
		this.foodPrice = foodPrice;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodType=" + foodType + ", foodCategory="
				+ foodCategory + ", foodImage=" + foodImage + ", foodDescription=" + foodDescription + ", foodPrice="
				+ foodPrice + "]";
	}
	
	

}
