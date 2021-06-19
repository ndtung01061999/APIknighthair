package booking.dto;

public class ServiceHairDTO {
	int id;
	String nameservice;
	int duration;
	int price;
	String image;
	public ServiceHairDTO() {};
	public ServiceHairDTO(int id, String nameservice, int duration, int price,String image) {
		super();
		this.id = id;
		this.nameservice = nameservice;
		this.duration = duration;
		this.price = price;
		this.image=image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameservice() {
		return nameservice;
	}
	public void setNameservice(String nameservice) {
		this.nameservice = nameservice;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
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
