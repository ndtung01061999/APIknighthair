package booking.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int idaccount;
	String name;
	String phone;
	String image;
	String address;
	String facebook;
	int iddistrict;
	public Customer() {}
	
	public Customer(int id, int idaccount, String name, String phone, String image,
			int iddistrict,String address) {
		super();
		this.id = id;
		this.idaccount = idaccount;
		this.name = name;
		this.phone = phone;
		this.image = image;
		this.iddistrict = iddistrict;
		this.address=address;
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

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
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

	public int getIddistrict() {
		return iddistrict;
	}

	public void setIddistrict(int iddistrict) {
		this.iddistrict = iddistrict;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
