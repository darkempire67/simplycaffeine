package simplycaffeine.model;

public class StatUserInfoOneDrink {
	int userID;
	int qty;
	String coffeeName;

	public StatUserInfoOneDrink(int userid, String qty, String coffeeName) {
		userID = userid;
		this.qty = Integer.parseInt(qty);

	}
}
