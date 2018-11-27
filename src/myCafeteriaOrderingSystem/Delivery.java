package myCafeteriaOrderingSystem;

public class Delivery {
	String delID;
	String delName;
	String phoneNumber;
	MealTime delTime;
	
	public Delivery(String del_id, String del_name, String xphoneNumber, MealTime del_time) {
		delID = del_id;
		delName = del_name;
		phoneNumber = xphoneNumber;
		delTime = del_time;
	}
	
	public String getDelID() {
		return delID;
	}
	
	public String getDelName() {
		return delName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public MealTime getDelTime() {
		return delTime;
	}
	
	
	
	public void setDelID(String del_id) {
		delID = del_id;
	}
	
	public void setDelName(String del_name) {
		delName = del_name;
	}
	
	public void setPhoneNumber(String del_phoneNumber) {
		phoneNumber = del_phoneNumber;
	}
	
	public void setDelTime(MealTime del_time) {
		delTime = del_time;
	}

}
