package myCafeteriaOrderingSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orders {
	String orderID;
	String custID;
	String delieveryID;
	double totalPrice;
	Date startTime;
	Boolean paid;
	String remark;
	List<OrderMenu> OrderMenuList = new ArrayList<OrderMenu>();
	Pay orderPay;
	MealStatus status;
	
	public Orders(String order_id, String cust_id, String delivery_id, double total_price, Date start_time, Boolean xpaid, String xremark)throws SQLException {
		impleDatabaseOperations temp = new impleDatabaseOperations();
		orderID = order_id;
		custID = cust_id;
		delieveryID = delivery_id;
		totalPrice = total_price;
		startTime = start_time;
		paid = xpaid;
		remark = xremark;
		OrderMenuList = temp.getOrderMenu(order_id);
		orderPay = temp.getPay(order_id);
		status = temp.getMealStatus(order_id);
	}
	
	public Orders(String order_id, String cust_id, String delivery_id, double total_price, Date start_time, Boolean xpaid, String xremark, ArrayList<OrderMenu> Order_menuList, Pay order_pay, MealStatus xstatus) {
		orderID = order_id;
		custID = cust_id;
		delieveryID = delivery_id;
		totalPrice = total_price;
		startTime = start_time;
		paid = xpaid;
		remark = xremark;
		OrderMenuList = Order_menuList;
		orderPay = order_pay;
		status = xstatus;
	}
	
	public String getOrderID() {
		return orderID;
	}
	
	public String getcustID() {
		return custID;
	}
	
	public String getDelieveryID() {
		return delieveryID;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public Boolean getPaid() {
		return paid;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public ArrayList<OrderMenu> getOrderMenuList(){
		return (ArrayList<OrderMenu>) OrderMenuList;
	}
	
	public Pay getOrderPay(){
		return orderPay;
	}
	
	public MealStatus getStatus(){
		return status;
	}
	
	
	public void setOrderMenuList(ArrayList<OrderMenu> order_menuList) {
		OrderMenuList = order_menuList;
	}
	
	public void setOrderPay(Pay order_pay) {
		orderPay = order_pay;
	}
	
	public void setMealStatus(MealStatus xstatus) {
		status = xstatus;
	}
	

}
