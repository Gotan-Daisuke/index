package entity;

public class LoginEntity{
	// id
	private Integer id;
	// ユーザーID
	private String userId;
	// ユーザーパスワード
	private String userpassword;
	// ユーザー名
	private String username;
	
	public LoginEntity(Integer id, String userId, String userpassword,String username) {
		this.id = 0;
		this.userId = null;
		this.userpassword = null;
		this.username = null;
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserpassword() {
		return userpassword;
	}
	
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsername() {
		return username;
	}
	
	public void setId(String username) {
		this.username = username;
	}
}
