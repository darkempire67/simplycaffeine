package simplycaffeine.model;

public class ReplenishInfo {

	int qty;
	String coffeeName;

	public ReplenishInfo(String qty, String coffeeName) {
		this.qty = Integer.parseInt( qty);
		this.coffeeName = coffeeName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	
	
}
