package simplycaffeine.model;

public class User {
	String first, last, email, password;
	int id;
	String coffeeName;
	String quantity;
	Double sumTotal;
	static int count = 0;

	public User(int id,String first, String last, String email, String password) {
		this.id = ++count;
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
	}

	public User(String first, String coffeeName, String quantity, Double sumTotal) {
		this.id = count;
		this.first = first;
		this.coffeeName = coffeeName;
		this.quantity = quantity;
		this.sumTotal = sumTotal;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public Double getSumTotal() {
		return sumTotal;
	}

	public void setSumTotal(Double sumTotal) {
		this.sumTotal = sumTotal;
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

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

}
