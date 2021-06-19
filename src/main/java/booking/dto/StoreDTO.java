package booking.dto;

import java.util.List;

public class StoreDTO {
	int id;
	int idaccount;
	String address;
	String phone;
	String facebook;
	String description;
	int idcity;
	int iddistrict;
	String image;
	String name;
	String time_start;
	String  time_end;
	int avgPoint;
	List<ServiceHairDTO> listservice;
	public StoreDTO() {
	}
	public StoreDTO(int id, int idaccount, String address, String phone, String facebook, String description,
			int idcity, int iddistrict, String image, String name, String time_start, String time_end, int avgPoint,
			List<ServiceHairDTO> listservice) {
		super();
		this.id = id;
		this.idaccount = idaccount;
		this.address = address;
		this.phone = phone;
		this.facebook = facebook;
		this.description = description;
		this.idcity = idcity;
		this.iddistrict = iddistrict;
		this.image = image;
		this.name = name;
		this.time_start = time_start;
		this.time_end = time_end;
		this.avgPoint = avgPoint;
		this.listservice = listservice;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdcity() {
		return idcity;
	}
	public void setIdcity(int idcity) {
		this.idcity = idcity;
	}
	public int getIddistrict() {
		return iddistrict;
	}
	public void setIddistrict(int iddistrict) {
		this.iddistrict = iddistrict;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public int getAvgPoint() {
		return avgPoint;
	}
	public void setAvgPoint(int avgPoint) {
		this.avgPoint = avgPoint;
	}
	public List<ServiceHairDTO> getListservice() {
		return listservice;
	}
	public void setListservice(List<ServiceHairDTO> listservice) {
		this.listservice = listservice;
	}
	
	
}
