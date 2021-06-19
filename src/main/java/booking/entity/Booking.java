package booking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idaccount")
	private Account accounts;

	String date;
	int pointcomment;
	String comment;
	int status;
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bookings")
	private List<Detail_Booking> listdeatail_booking;

	public Booking() {
	}

	public Booking(int id, Account accounts, String date, int pointcomment, String comment, int status,
			List<Detail_Booking> listdeatail_booking) {
		super();
		this.id = id;
		this.accounts = accounts;
		this.date = date;
		this.pointcomment = pointcomment;
		this.comment = comment;
		this.status = status;
		this.listdeatail_booking = listdeatail_booking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccounts() {
		return accounts;
	}

	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPointcomment() {
		return pointcomment;
	}

	public void setPointcomment(int pointcomment) {
		this.pointcomment = pointcomment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Detail_Booking> getListdeatail_booking() {
		return listdeatail_booking;
	}

	public void setListdeatail_booking(List<Detail_Booking> listdeatail_booking) {
		this.listdeatail_booking = listdeatail_booking;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", accounts=" + accounts + ", date=" + date + ", pointcomment=" + pointcomment
				+ ", comment=" + comment + ", status=" + status + ", listdeatail_booking=" + listdeatail_booking + "]";
	}

	
}
