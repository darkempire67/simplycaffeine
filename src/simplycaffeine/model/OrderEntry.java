package simplycaffeine.model;


public class OrderEntry {

	Integer id;
	String building;
	String roomNumber;
	String hour;
	String minutes;
	String period;

	
	public OrderEntry(Integer id, String building, String roomNumber, String hour, String minutes, String period) {
		this.id = id;
		this.building = building;
		this.roomNumber = roomNumber;
		this.hour = hour;
		this.minutes = minutes;
		this.period = period;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

}

