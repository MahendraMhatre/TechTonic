import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tracker {

	private Connect connect;
	private static final String INSERT_TRACKER = "insert into Tracker (UId,calories,expenses,Tdate) values (?,?,?,date('now'))";
	private static final String UPDATE_TRACKER = "UPDATE Tracker SET calories = ? , expenses = ?  WHERE UId = ? and Tdate= ? ";
	private static final String UPDATE_CALORIES = "UPDATE Tracker SET calories = ?  WHERE UId = ? and Tdate= ? ";
	private static final String UPDATE_EXPENSE = "UPDATE Tracker SET expenses = ?  WHERE UId = ? and Tdate= ? ";
	private static final String GET_CALEXP = "SELECT * FROM TRACKER  WHERE UId = ? and Tdate= ? ";
	private static final String query = "SELECT * from  Tracker ORDER BY Tdate DESC LIMIT 7 ";

	
	
	public Tracker() {
		connect = new Connect();
	}

	public void addOrder(int id, long calories, long expenses) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = connect.connect();
			ps = con.prepareStatement(INSERT_TRACKER);
			ps.setInt(1, id);
			ps.setLong(2, calories);
			ps.setLong(3, expenses);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

	}
	
	public int[] getCalExp(int id, String date) {
		Connection con = null;
		PreparedStatement ps = null;
         int result[] = {0,0};
		
		try {
			con = connect.connect();
			ps = con.prepareStatement(GET_CALEXP);
			ps.setInt(1, id);
			ps.setString(2, date);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result[0] = rs.getInt(3);
				result[1] = rs.getInt(4);
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}
   return result;
	}

	public void updateTracker(int id, String date, long calories, long expenses) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = connect.connect();
			ps = con.prepareStatement(UPDATE_TRACKER);
			ps.setLong(1, calories);
			ps.setLong(2, expenses);
			ps.setInt(3, id);
			ps.setString(4, date);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

	}

	public void updateCalories(int id, String date, long calories) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = connect.connect();
			ps = con.prepareStatement(UPDATE_CALORIES);
			ps.setLong(1, calories);
			ps.setInt(2, id);
			ps.setString(3, date);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

	}
	
	public void updateExpenses(int id, String date, long expenses) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = connect.connect();
			ps = con.prepareStatement(UPDATE_EXPENSE);
			ps.setLong(1, expenses);
			ps.setInt(2, id);
			ps.setString(3, date);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

	}
	
	public int[] query123(String date1, String date2 ) {
		Connection con = null;
		PreparedStatement ps = null;
       int count =0;
       int x[] = {0,0,0,0,0,0,0};
		try {
			con = connect.connect();
			ps = con.prepareStatement(query);
			//ps.setString(1, date1);
			//ps.setString(1, date2);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				x[count++] = rs.getInt(3);
				System.out.println(rs.getInt(3));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tracker tracker = new Tracker();
		// tracker.addOrder(1, 30, 20);
		//tracker.updateTracker(1, "2016-05-31", 50, 50);

	 // int x[] = tracker.getCalExp(1, "2016-05-31");
//	  for(int i = 0; i < x.length ;i++) {
//		  System.out.println(x[i]);
//	  }
//	
	tracker.query123("2016-06-01","2016-06-06" );
	}

}
