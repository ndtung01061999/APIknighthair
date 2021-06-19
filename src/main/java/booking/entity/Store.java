package booking.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "store")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int idaccount;
	String address;
	String phone;
	String facebook;
	String description;
	int iddistrict;
	String image;
	String name;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "stores")
	private List<Store_Service> listservice;

	public Store() {
	}

	public Store(int id, int idaccount, String address, String phone, String facebook, String description,
			int iddistrict, String image, String name, List<Store_Service> listservice) {
		super();
		this.id = id;
		this.idaccount = idaccount;
		this.address = address;
		this.phone = phone;
		this.facebook = facebook;
		this.description = description;
		this.iddistrict = iddistrict;
		this.image = image;
		this.name = name;
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

	public List<Store_Service> getListservice() {
		return listservice;
	}

	public void setListservice(List<Store_Service> listservice) {
		this.listservice = listservice;
	}

	
}
