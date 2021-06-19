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
@Table(name = "equipment_timeline")
public class Equipment_timeline {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idequipment")
	private Equipment equipments;

	String date;
	int ordinalnumber;

	public Equipment_timeline() {
	}

	public Equipment_timeline(int id, Equipment equipments, String date, int ordinalnumber) {
		super();
		this.id = id;
		this.equipments = equipments;
		this.date = date;
		this.ordinalnumber = ordinalnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipment getEquipments() {
		return equipments;
	}

	public void setEquipments(Equipment equipments) {
		this.equipments = equipments;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getOrdinalnumber() {
		return ordinalnumber;
	}

	public void setOrdinalnumber(int ordinalnumber) {
		this.ordinalnumber = ordinalnumber;
	};

}
