package myCafeteriaOrderingSystem;
import java.util.Date;

public class MealStatus {
	String status;
	int timeID;
	Date startTime;
	Date endTime;
	
	public MealStatus(String xstatus, int time_id, Date start_time, Date end_time) {
		status = xstatus;
		timeID = time_id;
		startTime = start_time;
		endTime = end_time;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getTimeID() {
		return timeID;
	}
	
	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}
	
	public void setStatus(String xstatus) {
		status = xstatus;
	}
	
	public void setTimeID(int time_id) {
		timeID = time_id;
	}
	
	public void setStartTime(Date start_time) {
		startTime = start_time;
	}

	public void setEndTime(Date end_time) {
		endTime = end_time;
	}
}
