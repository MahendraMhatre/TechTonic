import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CafeMenu {

	private static final String RETRIVE_FOOD = "SELECT  * FROM FoodItem INNER JOIN Cafe_Item ON FoodItem.Id = Cafe_Item.ItemId where Cafe_Item.CafeId = ? ";
	private static final String ADD_ITEM = "insert into FoodItem (Name,Calories,Price,Contents) values (?,?,?,?)";
	private Connect connect;
	private Menu menu;
	private FoodItem item;

	public CafeMenu() {
		connect = new Connect();
		menu = new Menu();

	}

	public void addItem(String name, long calories, long price, String content) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = connect.connect();
			ps = con.prepareStatement(ADD_ITEM);
			ps.setString(1, name);
			ps.setLong(2, calories);
			ps.setLong(3, price);
			ps.setString(4, content);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

	}

	public Menu displayItems(int id) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = connect.connect();
			ps = con.prepareStatement(RETRIVE_FOOD);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				item = new FoodItem(rs.getString(2), rs.getInt(1), rs.getLong(3), rs.getString(5), rs.getLong(4));
				menu.addItem(item);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

		return menu;
	}

	public static void main(String[] args) {
		Menu m;
		CafeMenu cf = new CafeMenu();
		System.out.println(cf.displayItems(2));

	}

}
