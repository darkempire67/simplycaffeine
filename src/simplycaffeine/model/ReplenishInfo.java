package simplycaffeine.model;

public class ReplenishInfo {

	int qty;
	String coffeeName;

	public ReplenishInfo(String qty, String coffeeName) {
		this.qty = Integer.parseInt( qty);
		this.coffeeName = coffeeName;
	}
}