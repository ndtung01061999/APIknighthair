package booking.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "equipment")
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idstore")
	private Store stores;
	
	String name;
	int type;
	int status;
	public Equipment(){}
	public Equipment(int id, Store stores, String name, int type,int status) {
		super();
		this.id = id;
		this.stores = stores;
		this.name = name;
		this.type = type;
		this.status=status;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	};
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	};
	
}
