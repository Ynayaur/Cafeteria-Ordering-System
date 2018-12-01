package LogicLayer;

import java.sql.SQLException;

import myCafeteriaOrderingSystem.impleDatabaseOperations;

public class Login {
	String UID;
	String UPW;
	//顾客1，送餐员2，餐厅员工3，菜单管理员4
	int UKind;
	
	public Login(){
		UID = null;
		UPW = null;
	}
	
	public Login(String uid, String upw) {
		UID = uid;
		UPW = upw;
		setUKind(UID);
	}
	
	public String getUID() {
		return UID;
	}
	
	
	public int getUKind() {
		return UKind;
	}
	
	
	private void setUKind(String uid) {
		impleDatabaseOperations login = new impleDatabaseOperations();
		
		try {
			UKind = login.getKind(uid);
			
			if(UKind == 0) {
				if(login.getDelivery(uid) != null) {
					UKind = 4;
				}
				
				else {
					throw new Exception("用户名或密码错误");
				}
				
			}
			
		}
		
		catch(Exception e) {
			
		}
	}
	
	
	public Boolean LoginAuth() throws Exception{
		impleDatabaseOperations login = new impleDatabaseOperations();
		
		if(UPW.equals(login.getPassword(UID))) {
			return true;
		}
		
		else {
			throw new Exception("用户名或密码错误");
		}
			
		
	}

}
