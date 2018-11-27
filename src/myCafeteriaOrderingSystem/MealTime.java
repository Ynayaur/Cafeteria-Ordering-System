package myCafeteriaOrderingSystem;
import java.util.Date;

public class MealTime {
	int id;
	Date startTime;
	Date endTime;

	public MealTime(int time_id, Date start_time, Date end_time) {
		id = time_id;
		startTime = start_time;
		endTime = end_time;
	}
	
	public int getID() {
		return id;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setID(int xid) {
		id = xid;
	}
	
	public void setStartTime(Date start_time) {
		startTime = start_time;
	}
	
	public void setEndTime(Date end_time) {
		endTime = end_time;
	}
}
