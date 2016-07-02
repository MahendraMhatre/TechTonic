import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CafeOrder {

	private Connect connect;
	private static final String INSERT_ORDER = "insert into Cafe_Order (UId,Items,total,Odate) values (?,?,?,date('now'))";
	private static final String RETRIEVE_ORDER = "Select * from Cafe_Order Where Odate = ? ";
	
	
	public CafeOrder() {
		connect = new Connect();
	}

	public void addOrder(int id, String items, long total) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = connect.connect();
			ps = con.prepareStatement(INSERT_ORDER);
			ps.setLong(1, id);
			ps.setString(2, items);
			ps.setLong(3, total);

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

	}

	public void displayOrder(String date) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = connect.connect();
			ps = con.prepareStatement(RETRIEVE_ORDER);
			ps.setString(1, date);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(3));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

	}
	
	

	public static void main(String[] args) {
		
		CafeOrder or = new CafeOrder();
		// or.addOrder(1, "pizzza pasta", 30);
		//or.displayOrder("2016-05-31");
		
	}

}
