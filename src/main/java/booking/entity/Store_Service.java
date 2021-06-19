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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "store_service")
public class Store_Service {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idstore")
	private Store stores;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idservice")
	private ServiceHair servicehairs;
	@Column
	int price;
	String image;
	public Store_Service() {
	}

	public Store_Service(int id, Store stores, ServiceHair servicehairs, int price,String image) {
		super();
		this.id = id;
		this.stores = stores;
		this.servicehairs = servicehairs;
		this.price = price;
		this.image=image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Store getStores() {
		return stores;
	}

	public void setStores(Store stores) {
		this.stores = stores;
	}

	public ServiceHair getServicehairs() {
		return servicehairs;
	}

	public void setServicehairs(ServiceHair servicehairs) {
		this.servicehairs = servicehairs;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
