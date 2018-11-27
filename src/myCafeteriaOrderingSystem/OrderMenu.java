package myCafeteriaOrderingSystem;

public class OrderMenu {
	String dishID;
	int dishNumber;
	
	public OrderMenu(String dish_id, int dish_number){
		dishID = dish_id;
		dishNumber = dish_number;
	}
	
	public String getDishID() {
		return dishID;
	}
	
	public int getDishNumber() {
		return dishNumber;
	}
	
	public void setDishID(String dish_id) {
		dishID = dish_id;
	}
	
	public void setDishNumber(int dish_number) {
		dishNumber = dish_number;
	}

}
