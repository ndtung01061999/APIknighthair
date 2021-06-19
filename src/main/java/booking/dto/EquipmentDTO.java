package booking.dto;

public class EquipmentDTO {
	int type;
	int numberOf;

	public EquipmentDTO() {
	}

	public EquipmentDTO(int type, int numberOf) {
		super();
		this.type = type;
		this.numberOf = numberOf;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getNumberOf() {
		return numberOf;
	}

	public void setNumberOf(int numberOf) {
		this.numberOf = numberOf;
	}

	
}
