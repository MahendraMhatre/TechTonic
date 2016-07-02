
public class Preference {
	private int id;
	private long calories;
	private long expenses;
	private String preference;

	public Preference() {
	}
	
	public Preference(int id, long calories, long expenses, String preference) {
		super();
		this.id = id;
		this.calories = calories;
		this.expenses = expenses;
		this.preference = preference;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCalories() {
		return calories;
	}

	public void setCalories(long calories) {
		this.calories = calories;
	}

	public long getExpenses() {
		return expenses;
	}

	public void setExpenses(long expenses) {
		this.expenses = expenses;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	@Override
	public String toString() {
		return "Preference [id=" + id + ", calories=" + calories + ", expenses=" + expenses + ", preference="
				+ preference + "]";
	}
	
	

}
