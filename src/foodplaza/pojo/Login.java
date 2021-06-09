package foodplaza.pojo;

public class Login {

	String loginType,username,password;

	public Login(String loginType, String username, String password) {
		super();
		this.loginType = loginType;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [loginType=" + loginType + ", username=" + username + ", password=" + password + "]";
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
