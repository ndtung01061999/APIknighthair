package booking.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service")
public class ServiceHair {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int duration;
	String nameservice;
	@JsonIgnore
//	@ManyToMany(mappedBy = "listservice", fetch = FetchType.EAGER)
//	private List<Store> ListStore;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "servicehairs")
    private List<Store_Service> liststore;
	public ServiceHair() {
	}
	
	public ServiceHair(int id, int duration, String nameservice) {
	super();
	this.id = id;
	this.duration = duration;
	this.nameservice = nameservice;
}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getNameservice() {
		return nameservice;
	}
	public void setNameservice(String nameservice) {
		this.nameservice = nameservice;
	}
	
}
