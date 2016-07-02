import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendingMenu {
	
	private static final String RETRIVE_VENDING = "SELECT  * FROM VItem  ";
	private static final String UPDATE_VENDING = "UPDATE VItem SET price = ?  WHERE Name = ? ";

	private Connect connect;
	private Menu menu;
	private FoodItem item;
	
	public VendingMenu() {
		connect = new Connect();
		menu = new Menu();
	}
	
	public Menu displayItems() {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = connect.connect();
			ps = con.prepareStatement(RETRIVE_VENDING);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				item = new FoodItem(rs.getString(2), rs.getInt(1), rs.getLong(3), "", rs.getLong(4));
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
		// TODO Auto-generated method stub

	}

}
