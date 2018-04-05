package simplycaffeine.model;

public class CoffeeEntry {

	Integer id;
	String coffeeName;
	String quantity;
	String cost;
	Double totalCost;

	public CoffeeEntry(Integer id, String coffeeName, String quantity, String cost, Double totalCost) {
		this.id = id;
		this.coffeeName = coffeeName;
		this.quantity = quantity;
		this.cost = cost;
		this.totalCost = totalCost;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

}
