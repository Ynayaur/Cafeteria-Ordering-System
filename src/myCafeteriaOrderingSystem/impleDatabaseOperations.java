package myCafeteriaOrderingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class impleDatabaseOperations implements DatabaseOperation{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://**.**.**.**:****/order_system?useSSL=false&autoReconnect=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL";
 
    static final String USER = "***";
    static final String PASS = "******";
    
    static  Connection conn = null;
    static  Statement stmt = null;
    

	
	public Boolean orderMenuInsert(String orderID, String dishID, int number) throws SQLException{
    	String sql = "INSERT INTO OrderMenu(order_id, dish_id,  dish_number) values(?,?,?)";
    	PreparedStatement pstmt;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		pstmt.setString(2, dishID);
    		pstmt.setInt(3, number);
 
    		
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return true;
	}
	
	public Boolean orderMenuDelete(String orderID, String dishID) throws SQLException{
		String sql = "delete from OrderMenu where order_id=? and dish_id=?";
	    PreparedStatement pstmt;
	    try {
	    	conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		pstmt.setString(2, dishID);
 
    		
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
	    } 
	    catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return true;
		
	}
	
	public ArrayList<OrderMenu> getOrderMenu(String orderID) throws SQLException{
		List<OrderMenu> reOrderList = new ArrayList<OrderMenu>();
		String sql = "SELECT * FROM OrderMenu WHERE order_id=?";
    	PreparedStatement pstmt;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             while(rs.next()){
            	 String dishID  = rs.getString("dish_id");
                 int dishNumber = rs.getInt("dish_number");
                 
                 OrderMenu orders = new OrderMenu(dishID, dishNumber);
                 
                 reOrderList.add(orders);                 
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;	
    	}
    	
    	System.out.println("Done");
    	return (ArrayList<OrderMenu>) reOrderList;
	}
	
	
	public Boolean setNumber(String orderID, String dishID, int number) throws SQLException{	
	    String sql = "update OrderMenu set dish_number =? where order_id=? and dish_id=?";
	    PreparedStatement pstmt;
	    
	    try {
	    	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, number);
	        pstmt.setString(2, orderID);
	        pstmt.setString(3, dishID);
	        
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } 
	    
	    catch(SQLException e){
    		throw e;
    	}
    	
    	System.out.println("Done");
    	return true;
	}
	
	
	public Boolean payInsert(String orderID, Date payTime, String payment) throws SQLException{
    	String sql = "INSERT INTO Pay(order_id, pay_time,  payment) values(?,?,?)";
    	Timestamp payTimeStamp = new Timestamp(payTime.getTime());

    	PreparedStatement pstmt;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		pstmt.setTimestamp(2, payTimeStamp);
    		pstmt.setString(3, payment);
 
    		
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return true;
	}
	
	
	public Date getPayTime(String orderID) throws SQLException {
		String sql = "SELECT  pay_time  FROM Pay WHERE order_id=?";
    	PreparedStatement pstmt;
    	Date payTime = new Date();
  
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 payTime  = rs.getTimestamp("pay_time");
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return payTime;
	}
	
	
	public String getPayment(String orderID) throws SQLException {
		String sql = "SELECT  payment  FROM Pay WHERE order_id=?";
    	PreparedStatement pstmt;
    	String payment = null;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 payment  = rs.getString("payment");
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return payment;
		
	}
	
	public Pay getPay(String orderID) throws SQLException {
		String sql = "SELECT * FROM Pay WHERE order_id=?";
    	PreparedStatement pstmt;
    	Date payTime = null;
    	String payment = null;
    	Pay pay = null;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 
            	 payTime  = rs.getTimestamp("pay_time");
            	 payment  = rs.getString("payment");
            	 
                 pay = new Pay(payTime, payment);
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	
    	System.out.println("Done");
    	return pay;		
	}


	public Boolean mealStatusInsert(String orderID, String Status, int timeID, Date startTime, Date endTime) throws SQLException{
		

    	String sql = "INSERT INTO MealStatus(order_id, status, time_id, start_time, end_time) values(?,?,?,?,?)";
    	Timestamp startTimeStamp = new Timestamp(startTime.getTime());
    	Timestamp endTimeStamp = new Timestamp(endTime.getTime());

    	PreparedStatement pstmt;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		pstmt.setString(2, Status);
    		pstmt.setInt(3, timeID);
    		pstmt.setTimestamp(4, startTimeStamp);
    		pstmt.setTimestamp(5, endTimeStamp);
 
    		
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	
    	System.out.println("Done");
    	return true;
		
	}
	
	public Boolean setStatus(String orderID, String Status) throws SQLException{
	    String sql = "update MealStatus set status =? where order_id=?";
	    PreparedStatement pstmt;
	    
	    try {
	    	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        
	        pstmt.setString(1, Status);
	        pstmt.setString(2, orderID);
	        
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } 
	    
	    catch(SQLException e){
	    	throw e;
    	}
    	
    	System.out.println("Done");
    	return true;
	}
	
	public Boolean setTimeID(String orderID, int timeID) throws SQLException {
		 String sql = "update MealStatus set time_id =? where order_id=?";
		    PreparedStatement pstmt;
		    
		    try {
		    	conn = DriverManager.getConnection(DB_URL,USER,PASS);
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        
		        pstmt.setInt(1, timeID);
		        pstmt.setString(2, orderID);
		        
		        pstmt.executeUpdate();
		        pstmt.close();
		        conn.close();
		    } 
		    
		    catch(SQLException e){
		    	throw e;
	    	}
	    	
	    	System.out.println("Done");
	    	return true;
	}
	
	
	public Boolean setStartTime(String orderID, Date startTime) throws SQLException {
		String sql = "update MealStatus set start_time=? where order_id=?";
		PreparedStatement pstmt;
		Timestamp startTimeStamp = new Timestamp(startTime.getTime());
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    pstmt = (PreparedStatement) conn.prepareStatement(sql);
		    
		    pstmt.setTimestamp(1, startTimeStamp);
		    pstmt.setString(2, orderID);
		    
		    pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		} 
		
		catch(SQLException e){
			throw e;
		}
		
		System.out.println("Done");
		return true;
	}
	
	
	public Boolean setEndTime(String orderID, Date EndTime) throws SQLException{
		String sql = "update MealStatus set end_time=? where order_id=?";
		PreparedStatement pstmt;
		Timestamp EndTimeStamp = new Timestamp(EndTime.getTime());
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    pstmt = (PreparedStatement) conn.prepareStatement(sql);
		    
		    pstmt.setTimestamp(1, EndTimeStamp);
		    pstmt.setString(2, orderID);
		    
		    pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		} 
		
		catch(SQLException e){
			throw e;
		}
		
		System.out.println("Done");
		return true;
	}
	
	
	public MealStatus getMealStatus(String orderID) throws SQLException {
		String sql = "SELECT * FROM MealStatus WHERE order_id=?";
    	PreparedStatement pstmt;
  
    	String status = null;
    	int time_id;
    	Date startTime = null;
    	Date endTime = null;
    	MealStatus reMealStatus = null;
    	
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 
            	 status  = rs.getString("status");
            	 time_id = rs.getInt("time_id");
            	 startTime  = rs.getTimestamp("start_time");
            	 endTime  = rs.getTimestamp("end_time");
            	 
                 reMealStatus = new MealStatus(status, time_id, startTime, endTime);
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	
    	System.out.println("Done");
    	return reMealStatus;
	}

	
	public MealTime getMealTime(int timeID) throws SQLException {
		String sql = "SELECT * FROM MealTime WHERE time_id=?";
    	PreparedStatement pstmt;
    	
    	MealTime reMealTime = null;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setInt(1, timeID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 
            	 int xtime_id  = rs.getInt("time_id");
            	 Date start_time = rs.getTimestamp("start_time"); 
            	 Date end_time = rs.getTimestamp("end_time"); 
            	 
            	 reMealTime = new  MealTime(xtime_id, start_time, end_time);
            	 
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	
    	System.out.println("Done");
    	return reMealTime;
		
	}
	
	
	public Boolean deliveryInsert(String delID, String delName, String phoneNumber, int timeID) throws SQLException{
    	String sql = "INSERT INTO  Delivery(del_id, del_name, del_phonenumber, time_id) values(?,?,?,?)";
    	
    	PreparedStatement pstmt;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, delID);
    		pstmt.setString(2, delName);
    		pstmt.setString(3, phoneNumber);
    		pstmt.setInt(4, timeID);
    		
    		
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return true;
	}
	
	
	public Boolean deliveryDelete(String delID) throws SQLException{
	    String sql = "delete from Delivery where del_id=? ";
	    PreparedStatement pstmt;
	    try {
	    	conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, delID);
 
    		
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
	    } 
	    catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return true;
	}
	
	
	public Delivery getDelivery(String delID) throws SQLException{
		String sql = "SELECT * FROM Delivery WHERE del_id=?";
    	PreparedStatement pstmt;
  
 
    	Delivery  reDelivery = null; 
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, delID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 
            	 String del_id  = rs.getString("del_id");
            	 String del_name = rs.getString("del_name");
            	 String phonenumber  = rs.getString("del_phonenumber");
            	 int time_id  = rs.getInt("time_id");
            	 
            	 MealTime del_time = getMealTime(time_id);
            	 
                 reDelivery  = new  Delivery(del_id, del_name, phonenumber, del_time);
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	
    	System.out.println("Done");
    	return reDelivery;
		
		
	
	}
	
	
	public Delivery getDeliveryx(int timeID) throws SQLException{
		
		String sql = "SELECT * FROM Delivery WHERE time_id=?";
    	PreparedStatement pstmt;
  
    	Delivery  reDelivery = null; 
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setInt(1, timeID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 
            	 String del_id  = rs.getString("del_id");
            	 String del_name = rs.getString("del_name");
            	 String phonenumber  = rs.getString("del_phonenumber");
            	 int time_id  = rs.getInt("time_id");
            	 
            	 MealTime del_time = getMealTime(time_id);
            	 
                 reDelivery  = new  Delivery(del_id, del_name, phonenumber, del_time);
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e) {
    		throw e;
    	}
    	
    	System.out.println("Done");
    	return reDelivery;
		
	}
	
	
	public Boolean setPhoneNumber(String delID, String phoneNumber) throws SQLException{
		String sql = "update Delivery set del_phonenumber=? where del_id=?";
		PreparedStatement pstmt;
		
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    pstmt = (PreparedStatement) conn.prepareStatement(sql);
		    
		    pstmt.setString(1, phoneNumber);
		    pstmt.setString(2, delID);
		    
		    pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		} 
		
		catch(SQLException e){
			throw e;
		}
		
		System.out.println("Done");
		return true;
	}
	
	
	
	public Boolean setDelTimeID(String delID, int timeID) throws SQLException{
		String sql = "update Delivery set time_id=? where del_id=?";
		PreparedStatement pstmt;
		
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    pstmt = (PreparedStatement) conn.prepareStatement(sql);
		    
		    pstmt.setInt(1, timeID);
		    pstmt.setString(2, delID);
		    
		    pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		} 
		
		catch(SQLException e){
			throw e;
		}
		
		System.out.println("Done");
		return true;
	}
	
	
	public Boolean ordersInsert(String orderID, String custID, String deliveryID, double totalPrice, Date startTime, Boolean paid, String Remark) throws SQLException{
		String sql = "INSERT INTO Orders(order_id, cust_id, delivery_id, total_price, start_time, paid, remark) values(?,?,?,?,?,?,?)";
		Timestamp startTimeStamp = new Timestamp(startTime.getTime());
		
    	PreparedStatement pstmt;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		pstmt.setString(2, custID);
    		pstmt.setString(3, deliveryID);
    		pstmt.setDouble(4, totalPrice);
    		pstmt.setTimestamp(5, startTimeStamp);
    		pstmt.setBoolean(6, paid);
    		pstmt.setString(7, Remark);
    		
    		
    		pstmt.executeUpdate();
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return true;
	}
	
	public String getDeliveryID(String orderID) throws SQLException {
		String sql = "SELECT delivery_id FROM Orders WHERE order_id=?";
    	PreparedStatement pstmt;
    	String deliveryID = null;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 deliveryID  = rs.getString("delivery_id");
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return deliveryID;
		
	}
	
	public double getTotalPrice(String orderID) throws SQLException{
		String sql = "SELECT total_price FROM Orders WHERE order_id=?";
    	PreparedStatement pstmt;
    	double totalPrice = 0;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 totalPrice  = rs.getDouble("total_price");
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return totalPrice;
		
	}
	
	public Date getStartTime(String orderID) throws SQLException {
		String sql = "SELECT start_time FROM Orders WHERE order_id=?";
    	PreparedStatement pstmt;
    	Date startTime = null;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	startTime = rs.getTimestamp("start_time");
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return startTime;
		
	}
	
	public String getRemark(String orderID) throws SQLException {
		String sql = "SELECT remark FROM Orders WHERE order_id=?";
    	PreparedStatement pstmt;
    	String remark = null;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 remark  = rs.getString("remark");
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return remark;
		
	}
	
	public Boolean getPaid(String orderID) throws SQLException {
		String sql = "SELECT paid FROM Orders WHERE order_id=?";
    	PreparedStatement pstmt;
    	Boolean paid = false;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, orderID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             if(rs.next()){
            	 paid  = rs.getBoolean("paid");
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}
    	System.out.println("Done");
    	return paid;
		
	}
	
	public Boolean setTotalPrice(String orderID, double totalPrice) throws SQLException{
		String sql = "update Orders set total_price =? where order_id=?";
		PreparedStatement pstmt;
		
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    pstmt = (PreparedStatement) conn.prepareStatement(sql);
		    
		    pstmt.setDouble(1, totalPrice);
		    pstmt.setString(2, orderID);
		    
		    pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		} 
		
		catch(SQLException e){
			throw e;
		}
		
		System.out.println("Done");
		return true;
	}
	
	public Boolean setRemark(String orderID, String remark) throws SQLException{
		String sql = "update Orders set remark =? where order_id=?";
		PreparedStatement pstmt;
		
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    pstmt = (PreparedStatement) conn.prepareStatement(sql);
		    
		    pstmt.setString(1, remark);
		    pstmt.setString(2, orderID);
		    
		    pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		} 
		
		catch(SQLException e){
			throw e;
		}
		
		System.out.println("Done");
		return true;
		
	}
	
	public Boolean setPaid(String orderID, Boolean paid) throws SQLException{
		String sql = "update Orders set paid =? where order_id=?";
		PreparedStatement pstmt;
		
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    pstmt = (PreparedStatement) conn.prepareStatement(sql);
		    
		    pstmt.setBoolean(1, paid);
		    pstmt.setString(2, orderID);
		    
		    pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		} 
		
		catch(SQLException e){
			throw e;
		}
		
		System.out.println("Done");
		return true;
	}
	
	public ArrayList<Orders> getAllOrders(String custID) throws SQLException{
		List<Orders> reOrderList = new ArrayList<Orders>();
		String sql = "SELECT * FROM Orders WHERE cust_id=?";
    	PreparedStatement pstmt;
    	
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		pstmt = (PreparedStatement) conn.prepareStatement(sql);
    		pstmt.setString(1, custID);
    		
    		ResultSet rs = pstmt.executeQuery();
    	        
             while(rs.next()){
            	 
            	 String orderID  = rs.getString("order_id");
         		 String xcustID = rs.getString("cust_id");
         		 String deliveryID = rs.getString("delivery_id");
         		 double totalPrice = rs.getDouble("total_price");
         		 Date startTime = rs.getTimestamp("start_time");
         		 Boolean xpaid = rs.getBoolean("paid");
         		 String xremark = rs.getString("remark");
                 
                 Orders orders = new Orders(orderID, xcustID, deliveryID, totalPrice, startTime, xpaid, xremark);
                 
                 reOrderList.add(orders);
                 
                 
             }
    		
    		
    		pstmt.close();
    		conn.close();
    	}
    	
    	catch(SQLException e){
    		throw e;
    	}

    	
    	System.out.println("Done");
    	return (ArrayList<Orders>) reOrderList;
		
	}
	


	
//    public static void main(String[] args) throws SQLException {
//    	impleDatabaseOperations test = new impleDatabaseOperations();
//    	
////        Connection conn = null;
////        Statement stmt = null;
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//    
//           // conn = DriverManager.getConnection(DB_URL,USER,PASS);
//        }
//       
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        finally{
// 
//	        try{
//	            if(stmt!=null) stmt.close();
//	        }
//	        catch(SQLException se2){
//	        }
//	        try{
//	            if(conn!=null) conn.close();
//	        }
//	        catch(SQLException se){
//	            se.printStackTrace();
//	        }
//        }
        
      
        
        //test.customerRegister(1,"C002", "", false, "test@test.com", "123456", "1234567");
        //System.out.println(test.getcustName("C002")); 
        //test.orderMenuInsert(String orderID, "1", int number)
       // Calendar date = Calendar.getInstance();
      //取得指定时区的时间：　　　　　　
     // TimeZone zone = TimeZone.getTimeZone("GMT+8:00");
      //Calendar date = Calendar.getInstance(zone);
        
       
 
        //date.setTime(TimeZone.getTimeZone("Asia/Shanghai")); 
        //date.getTime();
        
//        Date date1 = new Date();
//        Date date2 = new Date(118, 10, 26, 20, 18, 0);
        
//        test.deliveryInsert("d002", "test", "00012345678", 1);
//        test.ordersInsert("o001", "c001", "d001", 36, date1, true, "");
//        test.orderMenuInsert("o001", "d002", 1);
//        test.payInsert("o001", date2, "现金");
//        test.mealStatusInsert("o001", "完成配餐", 1, date1, date2);

//        test.setNumber("o001", "d001", 1);
//        test.setTotalPrice("o001", 12);
//        test.setRemark("o001", "test");
//        test.setPaid("o001", false);
//        test.setStatus("o001", "派送中");
//        test.setTimeID("o001", 2);
//        test.setStartTime("o001", date1);
//        test.setEndTime("o001", date1);
//        test.setPhoneNumber("d001", "00000000000");
//        test.setDelTimeID("d001", 2);
        
        
        
//		  test.orderMenuDelete("o001", "d002");
//     	  test.deliveryDelete("d002");
      
//    	
//    	
//    	
//    	
//    	System.out.println(test.getPayment("o001"));
//    	System.out.println(test.getDeliveryID("o001"));
//    	System.out.println(test.getTotalPrice("o001"));
//    	System.out.println(test.getRemark("o001"));
//    	System.out.println(test.getPaid("o001"));
    	
        
//        ArrayList<OrderMenu> ordermenu = test.getOrderMenu("o001");
//	    for(int i = 0; i < ordermenu.size(); i++) {
//	    	System.out.printf("%s    %d\n", ordermenu.get(i).getDishID(), ordermenu.get(i).getDishNumber());
//	    }
//        
//        Date date = test.getPayTime("o001");
//        SimpleDateFormat myFmt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//    	String sdate = myFmt.format(date);
//        System.out.printf("%s\n", sdate); 
//        
//        
//        Pay pay = test.getPay("o001");
//        
//        String pdate = myFmt.format(pay.getPayTime());
//        System.out.printf("%s   %s\n", pdate, pay.getPayment());
//        
//        
//        MealStatus mealstatus = test.getMealStatus("o001");
//        String msdate = myFmt.format(mealstatus.getStartTime());
//        String medate = myFmt.format(mealstatus.getEndTime());
//        System.out.printf("%s  %d  %s  %s\n", mealstatus.getStatus(), mealstatus.getTimeID(), msdate, medate); 
//        
//        SimpleDateFormat myFmt2 = new SimpleDateFormat("HH:mm:ss");
//    	Delivery del = test.getDelivery("d001");
//     	String dlsdate = myFmt2.format(del.getDelTime().getStartTime());
//        String dledate = myFmt2.format(del.getDelTime().getEndTime());
//    	System.out.printf("%s  %s %s  %d  %s %s \n", del.getDelID(), del.getDelName(), del.getPhoneNumber(), del.getDelTime().getID(), dlsdate, dledate); 
//  
//    	
// 
//    	
//    	Delivery del2 = test.getDeliveryx(2);
//    	String dlsdate2 = myFmt2.format(del2.getDelTime().getStartTime());
//        String dledate2 = myFmt2.format(del2.getDelTime().getEndTime());
//    	System.out.printf("%s  %s  %s %d  %s %s \n", del2.getDelID(), del2.getDelName(), del2.getPhoneNumber(), del2.getDelTime().getID(), dlsdate2, dledate2); 
//    	
//    	
//    	MealTime mealt = test.getMealTime(1);
//       	String mlsdate = myFmt2.format(mealt.getStartTime());
//        String mledate = myFmt2.format(mealt.getEndTime());
//    	System.out.printf("%d  %s %s \n",mealt.getID(), mlsdate, mledate); 
//    	
//    	 Date date3 = test.getStartTime("o001");
//     	String sdate2 = myFmt.format(date3);
//         
//         System.out.printf("%s\n", sdate2); 
         
    	
//    	ArrayList<Orders> ordersList = test.getAllOrders("c001");
//    	for(int i = 0; i < ordersList.size(); i++) {
// 	    	System.out.printf("%s %s %s %f %s %s\n", ordersList.get(i).getOrderID(), ordersList.get(i).getcustID(), ordersList.get(i).getDelieveryID(), ordersList.get(i).getTotalPrice(), ordersList.get(i).getPaid(), ordersList.get(i).getRemark() );
// 	        ArrayList<OrderMenu> ordermenu = ordersList.get(i).getOrderMenuList();
// 		    
// 	        for(int j = 0; j < ordermenu.size(); j++) {
// 		    	System.out.printf("%s    %d\n", ordermenu.get(j).getDishID(), ordermenu.get(j).getDishNumber());
// 		    }
// 	        
// 	        Pay pay = ordersList.get(i).getOrderPay();
// 	        
// 	        String pdate = myFmt.format(pay.getPayTime());
// 	        System.out.printf("%s   %s\n", pdate, pay.getPayment());
// 	        
// 	        MealStatus mealstatus = ordersList.get(i).getStatus();
// 	        String msdate = myFmt.format(mealstatus.getStartTime());
// 	        String medate = myFmt.format(mealstatus.getEndTime());
// 	        System.out.printf("%s  %d  %s  %s\n\n\n\n\n", mealstatus.getStatus(), mealstatus.getTimeID(), msdate, medate); 
// 	        
//    	
//    	}
        
        
        //test.payInsert("o001", date, "Cash");
        //test.mealStatusInsert("o001", "Done", 1, date1, date2);
        
        //test.deliveryInsert("d002", "送餐员", "01234567890", 1);
        //test.ordersInsert("o002", "c001", "d002",25.236, date1, false, "少辣");
        //OrderMenu要改；
        //test.orderMenuInsert("o002", "2", 2);
       // List<Orders> resList = new ArrayList<Orders>();
       // resList = test.getOrderMenu("o002");
//        resList = test.getAllOrders("c001");
//        
//        for(int i = 0; i < resList.size(); i++) {
//        	System.out.printf("%s    %d\n", resList.get(i).getDishID(), resList.get(i).getDishNumber());
//        }
//        SimpleDateFormat myFmt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//		String date = myFmt.format(test.getPayTime("o001"));
//        
//        System.out.printf("%s\n", date); 
//    }

}
