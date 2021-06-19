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
@Table(name = "district")
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcity")
	private City citys;

	public District() {
	};

	public District(int id, String name, String type, City citys) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.citys = citys;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public City getCitys() {
		return citys;
	}

	public void setCitys(City citys) {
		this.citys = citys;
	}

}
