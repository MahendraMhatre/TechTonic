import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	private Connect connect;
	private Preferences preference;
	private Card card;
	private Users user;

	private static final String LOGIN_DETAILS = "SELECT * FROM Users WHERE UserName = ? and Password = ? ";
	private static final String LOGIN_CARD = "SELECT * FROM Users WHERE CardNumber = ? ";
	private static final String GET_PREF = "SELECT * FROM Preference WHERE Id = ? ";
	private static final String ADD_USER = "insert into Users (FirstName,LastName,UserName,Password,CardNumber) values (?,?,?,?,?)";
	private static final String ADD_PREF = "insert into Prefrence (preferences) values (?)";

	
	public Login() {
		connect = new Connect();
		preference = new Preferences();
		card = new Card();
	}

	public Users login(String cardNumber) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = connect.connect();
			ps = con.prepareStatement(LOGIN_CARD);
			ps.setString(1, cardNumber);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				card.setCard(rs.getString(6));
				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), preference, card);
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			} else {
				throw new SQLException("Invalid Card Number");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}

		return user;
	}

	
	
	public void addPref(String prefer) {
		 Connection con  = null;
		 PreparedStatement ps = null;
		 try {
				con = connect.connect();
				ps = con.prepareStatement(ADD_PREF);
				ps.setString(1, prefer);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {

				connect.closeStatement(ps);
				connect.closeConnection(con);

			}
	
	
		
	}
	public void addUser(Users user) {
		 Connection con  = null;
		 PreparedStatement ps = null;
		 try {
				con = connect.connect();
				ps = con.prepareStatement(ADD_USER);
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());
				ps.setString(3, "xyz");
				ps.setString(4, "xyz");
				ps.setString(5,"1234");
				ps.executeUpdate();
			

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {

				connect.closeStatement(ps);
				connect.closeConnection(con);

			}
	
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		Login l = new Login();
		Users x = l.login("123");
	//	System.out.println(x);
		
//		Preferences p = new Preferences(100, 10, 500, 20);
	//	Card c = new Card("1234-234-345");
	//	Users u = new Users(324, "Mahendra", "Mhatre", p, c);
	//	l.addUser(u);
	//	l.addPref("aaa");
		
		
		

	}

}
