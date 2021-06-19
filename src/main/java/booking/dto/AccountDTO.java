package booking.dto;

public class AccountDTO {
	int id;
	String name;
	String password;
	int type;
	public AccountDTO() {}
	public AccountDTO(int id, String name, String password, int type) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	};
	
	
	
}
