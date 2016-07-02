import java.util.ArrayList;

public class Cafe {
	private Menu menu;
	private String name;

	public Cafe() {
		menu = new Menu();

	}

	public Cafe(String name, Menu menu) {
		this.menu = menu;
		this.name = name;

	}

	@Override
	public String toString() {
		return menu.toString() + "Cafe [name=" + name + "]";
	}

	public static void main(String[] args) {

		Menu m = new Menu();
		ArrayList<String> content = new ArrayList();
		content.add("sodium");
		content.add("carb");
		content.add("proteins");
		FoodItem f1 = new FoodItem("Chicken Tenders", 123, 100, "", 10);
		FoodItem f2 = new FoodItem("Curl Fires", 124, 100, "", 3.5);
		FoodItem f3 = new FoodItem("Pizza Slice", 125, 100, "", 4.5);
		m.addItem(f1);
		m.addItem(f2);
		m.addItem(f3);
		Cafe cafe = new Cafe("Broncos", m);

		System.out.println(cafe);

	}

}
