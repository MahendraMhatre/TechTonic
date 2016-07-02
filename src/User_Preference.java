import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Preference {
	private Connect connect;
	private Preference preference;
	
	private static final String SET_PREF = "UPDATE Preference SET calories = ? , expenses = ? ,preferences = ?  WHERE UId = ? ";
	private static final String GET_PREF = "SELECT * from Preference WHERE UId = ? ";
	
	public User_Preference() {
		connect = new Connect();
	}
	
	public void updatePreference(int id,long calories, long expenses ,String preferences) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = connect.connect();
			ps = con.prepareStatement(SET_PREF);
			ps.setLong(1, calories);
			ps.setLong(2, expenses);
			ps.setString(3, preferences);
			ps.setInt(4, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

	}
	
	public Preference getPref(int id) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = connect.connect();
			ps = con.prepareStatement(GET_PREF);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				   preference =  new Preference(rs.getInt(1), rs.getLong(2), rs.getLong(3), rs.getString(4));
					System.out.println(rs.getInt(1) + " " + rs.getLong(2) + " " + rs.getString(4));
			} else {
				throw new SQLException("User not found");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

		return preference;
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User_Preference user = new User_Preference();
		user.updatePreference(1, 1000, 100, "Low sugar");
		Preference p = user.getPref(1);
		System.out.println(p);
		
	}

}
