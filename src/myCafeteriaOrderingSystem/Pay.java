package myCafeteriaOrderingSystem;
import java.util.Date;

public class Pay {
	Date payTime;
	//Ö§¸¶·½Ê½
	String payment;
	
	
	public Pay(Date pay_time, String xpayment){
		payTime = pay_time;
		payment = xpayment;
	}
	
	public Pay() {
		payTime = null;
		payment = null;
	}
	
	public Date getPayTime() {
		return payTime;
	}
	
	public String getPayment() {
		return payment;
	}
	
	public void setPayTime(Date pay_time) {
		payTime = pay_time;
	}
	
	public void getPayment(String xpayment) {
		payment = xpayment;
	}

}
