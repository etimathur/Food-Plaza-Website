package foodplaza.pojo;

public class Order {

	private int orderId;
	private double orderBill;
	private String custEmailId,orderStatus,orderDate;
	public Order(int orderId, double orderBill, String custEmailId, String orderStatus, String orderDate) {
		super();
		this.orderId = orderId;
		this.orderBill = orderBill;
		this.custEmailId = custEmailId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}
	public Order( String custEmailId, String orderStatus,double orderBill, String orderDate) {
		super();
		this.orderBill = orderBill;
		this.custEmailId = custEmailId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getOrderBill() {
		return orderBill;
	}
	public void setOrderBill(double orderBill) {
		this.orderBill = orderBill;
	}
	public String getCustEmailId() {
		return custEmailId;
	}
	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderBill=" + orderBill + ", custEmailId=" + custEmailId
				+ ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
	}
	
	
}
