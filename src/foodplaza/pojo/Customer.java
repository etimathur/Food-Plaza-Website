package foodplaza.pojo;

public class Customer {

	private int custId;
	private String custName,custEmail,custPassword,custAddress;
	private long custContactNo;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddresss(String custAddresss) {
		this.custAddress = custAddresss;
	}
	public long getCustContactNo() {
		return custContactNo;
	}
	public void setCustContactNo(long custContactNo) {
		this.custContactNo = custContactNo;
	}
	public Customer(String custName, String custEmail, String custPassword, String custAddress,
			long custContactNo) {
		super();
		//this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.custAddress = custAddress;
		this.custContactNo = custContactNo;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custPassword="
				+ custPassword + ", custAddresss=" + custAddress + ", custContactNo=" + custContactNo + "]";
	}
	
}
