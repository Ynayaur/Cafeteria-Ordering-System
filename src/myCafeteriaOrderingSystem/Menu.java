package myCafeteriaOrderingSystem;

public class Menu {
	String dishID;
	String dishName;
	double price;
	double bargainPrice;
	Boolean isBargain;

	public Menu(){
	}
	
	public void setDishID(String id){
		this.dishID = id;
	}
	
	public void setDishName(String dishname){
		this.dishName = dishname;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setBargainPrice(double bargainprice){
		this.bargainPrice = bargainprice;
	}
	
	public void setIsBargain(Boolean isbargain){
		this.isBargain = isbargain;
	}
	
	public String getDishID(){
		return this.dishID;
	}
	
	public String getDishName(){
		return this.dishName;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public double getBargainPrice(){
		return this.bargainPrice ;
	}
	
	public Boolean getIsBargain(){
		return this.isBargain;
	}

}
