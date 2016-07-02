import java.util.ArrayList;

public class FoodItem {
	private String name;
	private int id;
	private double calories;
	private String contents;
	private double price;

	@Override
	public String toString() {
		return "FoodItem [name=" + name + ", id=" + id + ", calories=" + calories + ", contents=" + contents
				+ ", price=" + price + "]";
	}

	public FoodItem() {
		price = 0;
		calories = 0;
		name = "xyz";
		id = 0;
		contents = "";
	}

	public FoodItem(String name, int id, double calories, String contents, double price) {
		super();
		this.name = name;
		this.id = id;
		this.calories = calories;
		this.contents = contents;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
