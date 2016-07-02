
class Preferences {
	
	private double calorie_total;
	private double calorie_current;
	
	private double expense_total;
	private double expense_current;
	
	Preferences()
	{	
		calorie_current= 0.0; 
		calorie_total = 0.0; 
		expense_total=0.0;
		expense_current=0.0;
	}
	
	Preferences(int calorie_total, int calorie_current, int expense_total, int expense_current)
	{
		this.calorie_total=calorie_total;
		this.calorie_current= calorie_current;
		this.expense_total = expense_total; 
		this.expense_current = expense_current;
	}

	
	@Override
	public String toString() {
		return "Preferences [calorie_total=" + calorie_total + ", calorie_current=" + calorie_current
				+ ", expense_total=" + expense_total + ", expense_current=" + expense_current + "]";
	}
	
	public void set_CalorieCurrent(int calorie_current)
	{
		this.calorie_current = calorie_current;		
	}
	
	public double get_CalorieTotal()
	{
		return calorie_total; 
	}
	
	public void set_CalorieRemaining(int calorie_current, int calorie_total )
	{
		calorie_total = calorie_total - calorie_current;
	}
	
	public double get_ExpensePreferences()
	{
		return expense_total; 
	}
	
	public void set_ExpensePreferences(int expense_total)
	{	
		this.expense_total=expense_total; 			
	}
	public void set_ExpenseRemaining(int expense_current, int expense_total )
	{
		expense_total = expense_total - expense_current;
	}
	
	

}
