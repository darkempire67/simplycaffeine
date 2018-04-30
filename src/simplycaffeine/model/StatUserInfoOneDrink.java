package simplycaffeine.model;

public class StatUserInfoOneDrink {
	int userID;
	int qty;
	String coffeeName;
Double total;
	
	public StatUserInfoOneDrink(int userid, String qty, String coffeeName) {
		this.userID = userid;
		this.qty = Integer.parseInt(qty);

	}
public StatUserInfoOneDrink(int userid, Double total){
	this.userID = userid;
	this.total = total;
}
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public int getUserID() {
		return userID;
	}

	public int getQty() {
		return qty;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

}