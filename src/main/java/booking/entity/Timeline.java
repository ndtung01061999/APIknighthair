package booking.entity;

import java.sql.Time;

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
@Table(name = "timeline")
public class Timeline {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idstore")
	private Store stores;

	String time_start;
	String time_end;
	int druration;

	public Timeline() {
	}

	

	public Timeline(int id, Store stores, String time_start, String time_end, int druration) {
		super();
		this.id = id;
		this.stores = stores;
		this.time_start = time_start;
		this.time_end = time_end;
		this.druration = druration;
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



	public int getDruration() {
		return druration;
	}

	public void setDruration(int druration) {
		this.druration = druration;
	}
}
