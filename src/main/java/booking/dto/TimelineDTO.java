package booking.dto;

public class TimelineDTO {
	int id;
	String time;
	int number;

	public TimelineDTO() {
	}

	public TimelineDTO(int id, String time, int number) {
		super();
		this.id = id;
		this.time = time;
		this.number = number;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
