package booking.entity;

import javax.persistence.Column;
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
@Table(name = "detail_booking")
public class Detail_Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbooking")
	private Booking bookings;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idet")
	private Equipment_timeline equipment_timelines;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idstore_service")
	private Store_Service store_services;
	public Detail_Booking() {
		
	}

	public Detail_Booking(int id, Booking bookings, Equipment_timeline equipment_timelines, Store_Service store_services) {
		super();
		this.id = id;
		this.bookings = bookings;
		this.equipment_timelines = equipment_timelines;
		store_services = store_services;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Booking getBookings() {
		return bookings;
	}

	public void setBookings(Booking bookings) {
		this.bookings = bookings;
	}

	
	public Equipment_timeline getEquipment_timelines() {
		return equipment_timelines;
	}

	public void setEquipment_timelines(Equipment_timeline equipment_timelines) {
		this.equipment_timelines = equipment_timelines;
	}

	public Store_Service getStore_services() {
		return store_services;
	}

	public void setStore_services(Store_Service store_services) {
		this.store_services = store_services;
	}

}
