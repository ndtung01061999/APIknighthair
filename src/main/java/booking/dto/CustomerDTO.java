package booking.dto;

public class CustomerDTO {
	int id;
	int idaccount;
	String name;
	String phone;
	String image;
	String address;
	String district;
	String city;
	String facebook;
	int iddistrict;
	int idcity;
	public CustomerDTO() {}
	public CustomerDTO(int id, int idaccount, String name, String phone, String image, String address, String district,
			String city, int iddistrict, int idcity) {
		super();
		this.id = id;
		this.idaccount = idaccount;
		this.name = name;
		this.phone = phone;
		this.image = image;
		this.address = address;
		this.district = district;
		this.city = city;
		this.iddistrict = iddistrict;
		this.idcity = idcity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdaccount() {
		return idaccount;
	}
	public void setIdaccount(int idaccount) {
		this.idaccount = idaccount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getIddistrict() {
		return iddistrict;
	}
	public void setIddistrict(int iddistrict) {
		this.iddistrict = iddistrict;
	}
	public int getIdcity() {
		return idcity;
	}
	public void setIdcity(int idcity) {
		this.idcity = idcity;
	}
	
	
	
}
