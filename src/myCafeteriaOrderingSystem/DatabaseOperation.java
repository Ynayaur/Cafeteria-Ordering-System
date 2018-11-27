package myCafeteriaOrderingSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public interface DatabaseOperation {
//	public Boolean customerRegister(int kind, String custID, String custName, Boolean payroll, String custMail, String password, String phoneNumber);
//	public Boolean setRegistered(String custID, Boolean status);
//	public Boolean setPayroll(String custID, Boolean status);
//	public Boolean setMail(String custID, String mail);
//	public Boolean setPassword(String custID, String password);
//	public Boolean setPhonenumben(String custID, String phonenumber);
//	
//	public String getKind(String custID);
//	public String getcustName(String custID);
//	public String getcustID(String custID);
//	public Boolean getRegistered(String custID);
//	public Boolean getPayroll(String custID);
//	//public String getAddress(String custID);
//	public String getMail(String custID);
//	public String getPhonenumben(String custID);
//	
//	
//	
//	public Boolean menuInsert(String dishID, String dishName, double dishPrice, double bargainPrice, Boolean isBargain);
//	public Boolean setName(String dishID, double dishName);
//	public Boolean setPrice(String dishID, double dishPrice);
//	public Boolean setBargainPrice(String dishID, double bargainPrice);
//	public Boolean setIsBargain();
//	public Boolean deleteDish(String dishID);
//	
//	public double getPrice(String dishID);
//	public double getDishName(String dishID);
//	public double getIsBargain(String dishID);
//	public double getBargainPrice(String dishID);
//	public ArrayList<Menu> getMenu();
//	
//	
//	public Boolean addressInsert(String custID, String address);
//	public Boolean addressDelete(String custID, String address);
//	public ArrayList<String> getAddress(String custID);
//	
//	//
	public Boolean orderMenuInsert(String orderID, String dishID, int number);
	public Boolean orderMenuDelete(String orderID, String dishID);
	public ArrayList<OrderMenu> getOrderMenu(String orderID)throws SQLException;
	public Boolean setNumber(String orderID, String dishID, int number);
	
	
	public Boolean payInsert(String orderID, Date payTime, String payment);
	public Date getPayTime(String orderID)throws SQLException;
	public String getPayment(String orderID)throws SQLException;
	public Pay getPay(String orderID)throws SQLException;
	
	
	public Boolean mealStatusInsert(String orderID, String Status, int timeID, Date startTime, Date endTime);
	public Boolean setStatus(String orderID, String Status);
	public Boolean setTimeID(String orderID, int timeID);
	public Boolean setStartTime(String orderID, Date startTime);
	public Boolean setEndTime(String orderID, Date EndTime);
	public MealStatus getMealStatus(String orderID)throws SQLException;
	
	public Boolean deliveryInsert(String delID, String delName, String phoneNumber, int timeID);
	public Boolean deliveryDelete(String delID);
	public Delivery getDelivery(String delID)throws SQLException;
	public Delivery getDeliveryx(int timeID)throws SQLException;
	public Boolean setPhoneNumber(String delID, String phoneNumber);
	public Boolean setDelTimeID(String delID, int timeID);
	
	public MealTime getMealTime(int timeID)throws SQLException;
	
	public Boolean ordersInsert(String orderID, String custID, String deliveryID, double totalPrice, Date startTime, Boolean paid, String Remark);
	public String getDeliveryID(String orderID)throws SQLException;
	public double getTotalPrice(String orderID)throws SQLException;
	public Date  getStartTime(String orderID)throws SQLException;
	public String getRemark(String orderID)throws SQLException;
	public Boolean getPaid(String orderID)throws SQLException;
	public Boolean setTotalPrice(String orderID, double totalPrice);
	public Boolean setRemark(String orderID, String remark);
	public Boolean setPaid(String orderID, Boolean paid);
	public ArrayList<Orders> getAllOrders(String custID)throws SQLException;
	

}
