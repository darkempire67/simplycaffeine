package simplycaffeine.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderEntry {

	Integer id;
	String building;
	String roomNumber;
	String hour;
	String minutes;
	String period;
	int order1;
	int order2;
	int order3;
	int order4;
	Scanner input = new Scanner(System.in);
	String fileName = "OrderStats.txt";
	File file = new File(fileName);
	StringBuilder orders;

	public OrderEntry(Integer id, String building, String roomNumber, String hour, String minutes, String period) {
		this.id = id;
		this.building = building;
		this.roomNumber = roomNumber;
		this.hour = hour;
		this.minutes = minutes;
		this.period = period;
		System.out.println("TESTING");

		Scanner fileTest = null;
		try {
			fileTest = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found! Program will now exit.");
			System.exit(1);
		}

		if (this.id == 1 || this.id == 2) {
			while (fileTest.hasNextLine()) {
				orders.append(fileTest.nextLine());
			}
		}
		System.out.println(orders.toString());
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
