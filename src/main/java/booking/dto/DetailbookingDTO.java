package booking.dto;

public class DetailbookingDTO {
	int id;
	int idstore;
	String namestore;
	int idservice;
	String nameservice;
	int price;
	int time;
	String timebooking;
	int idstore_service;
	String date;

	public DetailbookingDTO() {
	}

	public DetailbookingDTO(int id, int idstore, String namestore, int idservice, String nameservice, int price,
			int time, int idstore_service, String date) {
		super();
		this.id = id;
		this.idstore = idstore;
		this.namestore = namestore;
		this.idservice = idservice;
		this.nameservice = nameservice;
		this.price = price;
		this.time = time;
		this.idstore_service = idstore_service;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdstore() {
		return idstore;
	}

	public void setIdstore(int idstore) {
		this.idstore = idstore;
	}

	public String getNamestore() {
		return namestore;
	}

	public void setNamestore(String namestore) {
		this.namestore = namestore;
	}

	public int getIdservice() {
		return idservice;
	}

	public void setIdservice(int idservice) {
		this.idservice = idservice;
	}

	public String getNameservice() {
		return nameservice;
	}

	public void setNameservice(String nameservice) {
		this.nameservice = nameservice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getIdstore_service() {
		return idstore_service;
	}

	public void setIdstore_service(int idstore_service) {
		this.idstore_service = idstore_service;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimebooking() {
		return timebooking;
	}

	public void setTimebooking(String timebooking) {
		this.timebooking = timebooking;
	}
	
	
}
