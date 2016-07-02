import java.util.ArrayList;
import java.util.Iterator;

public class Menu {
	ArrayList<FoodItem> item;
	
	public Menu() {
		item =  new ArrayList();	
	}
	


	@Override
	public String toString() {
		return display();
		
	}

	public  void addItem(FoodItem f) { 
		
		item.add(f);
		}
	
	
	public  String display() {
		String s = "";
		Iterator<FoodItem> itr =  item.iterator();
		while(itr.hasNext()) {
	    	s = s + itr.next()+"\n";
	    }
		return s;
	}
	


}
