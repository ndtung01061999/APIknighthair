package booking.dto;

import java.util.List;

public class BookingDTO {
	int id;
	int idaccount;
	String date;
	int pointcomment;
	String comment;
	int status;
	List<DetailbookingDTO> listdetail;
	int total;
	public BookingDTO() {
	}
	public BookingDTO(int id, int idaccount, String date, int pointcomment, String comment, int status,
			List<DetailbookingDTO> listdetail, int total) {
		super();
		this.id = id;
		this.idaccount = idaccount;
		this.date = date;
		this.pointcomment = pointcomment;
		this.comment = comment;
		this.status = status;
		this.listdetail = listdetail;
		this.total = total;
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
	public List<DetailbookingDTO> getListdetail() {
		return listdetail;
	}
	public void setListdetail(List<DetailbookingDTO> listdetail) {
		this.listdetail = listdetail;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
