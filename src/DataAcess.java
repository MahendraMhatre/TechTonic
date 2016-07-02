
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAcess {
	private Connect connect;
	private static final String CREATE_CAFE = "CREATE TABLE IF NOT EXISTS Cafe (\n" + "	Id integer PRIMARY KEY,\n"
			+ " CafeName text NOT NULL\n" + ");";

/*	private static final String CREATE_VENDING = "CREATE TABLE IF NOT EXISTS VendingMachine (\n" + "	Id integer PRIMARY KEY,\n"
			+ " Name text NOT NULL\n" + ");"; */
	
	private static final String CREATE_USERS = "CREATE TABLE IF NOT EXISTS Users (\n" + "	Id integer PRIMARY KEY,\n"
			+ " FirstName text NOT NULL\n," + " LastName text NOT NULL\n," + " UserName text NOT NULL\n,"
			+ " Password text NOT NULL\n," + " CardNumber text NOT NULL\n" + ");";

	/*private static final String CREATE_EXPENSES = "CREATE TABLE IF NOT EXISTS Expenses (\n" + "	Id integer,\n"
			+ " PRIMARY KEY (Id) \n," + " FOREIGN KEY (Id) REFERENCES Card (Id) \n" + ");"; */

	private static final String CREATE_PREF = "CREATE TABLE IF NOT EXISTS Preference (\n" + "Id integer PRIMARY KEY,\n" + "UId integer not null,\n" 
			+ " calories integer \n," + " expenses integer \n," + " preferences text \n" + ");";

	
	
	private static final String CREATE_FOODITEM = "CREATE TABLE IF NOT EXISTS FoodItem (\n"
			+ "	Id integer PRIMARY KEY,\n" + " Name text NOT NULL\n," + " Calories integer \n," + " Price integer \n,"
			+ " Contents text NOT NULL \n" + ");";

	private static final String CREATE_VITEM = "CREATE TABLE IF NOT EXISTS VItem (\n"
			+ "	Id integer PRIMARY KEY,\n" + " Name text NOT NULL\n," + " Calories integer \n," + " Price integer, \n" +" Quantity integer \n" + ");";


	private static final String CAFE_ITEM = "CREATE TABLE IF NOT EXISTS Cafe_Item (\n" + "ItemId integer,\n"
			+ "CafeId integer,\n" + " FOREIGN KEY (ItemId) REFERENCES FoodItem (Id) \n"
			+ " FOREIGN KEY (CafeId) REFERENCES Cafe (Id) \n" + ");";
	
	
	/*private static final String VENDING_ITEM = "CREATE TABLE IF NOT EXISTS Vending_Item (\n" + "ItemId integer,\n"
			+ "VendingId integer,\n" + " FOREIGN KEY (ItemId) REFERENCES FoodItem (Id) \n"
			+ " FOREIGN KEY (VendingId) REFERENCES VendingMachine (Id) \n" + ");"; */

	//private static final String RETRIVE_FOOD = "SELECT  FoodItem.Name FROM FoodItem INNER JOIN Cafe_Item ON FoodItem.Id = Cafe_Item.ItemId where Cafe_Item.CafeId = ? ";

	private static final String CREATE_TRACKER = "CREATE TABLE IF NOT EXISTS Tracker (\n" + "Id integer,\n" + "	UId integer,\n"
			+ "calories integer not null,\n" + "expenses integer not null,\n" + "Tdate text not null" + ");";

	private static final String CREATE_ORDER = "CREATE TABLE IF NOT EXISTS Cafe_Order (\n"
			+ "Id integer Primary Key Default 1111,\n" + "UId integer not null,\n" + "Items text not null,\n"
			+ "total integer not null,\n" + "Odate text not null" + ");";

	public DataAcess() {
		connect = new Connect();
	}

	public void create() {

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = connect.connect();
			stmt = conn.createStatement();
			stmt.execute(CREATE_USERS);
			stmt.execute(CREATE_PREF);
			//stmt.execute(CREATE_VENDING);
			stmt.execute(CREATE_FOODITEM);
			stmt.execute(CREATE_CAFE);
			stmt.execute(CAFE_ITEM);
			stmt.execute(CREATE_TRACKER);
			stmt.execute(CREATE_ORDER);
			stmt.execute(CREATE_VITEM);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			connect.closeStatement(stmt);
			connect.closeConnection(conn);
		}

	}

	public void insertCard(String number) {
		String sql = "INSERT INTO Card(CardNumber) VALUES(?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			connect.closeStatement(pstmt);
			connect.closeConnection(conn);
		}
	}

	public void insertUsers(String firstName, String lastName, String userName, String password, String cardNumber) {
		String sql = "INSERT INTO Users(FirstName, LastName, UserName, Password, CardNumber) VALUES(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, userName);
			pstmt.setString(4, password);
			pstmt.setString(5, cardNumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			connect.closeStatement(pstmt);
			connect.closeConnection(conn);
		}
	} // insertUsers

	public static void main(String[] args) {

		DataAcess da = new DataAcess();
		da.create();
	}

	/*
	 * select FoodItem.Name from FoodItem inner join Cafe_Item On FoodItem.Id =
	 * Cafe_Item.ItemId where Cafe_Item.CafeId = 1
	 */

	/*
	 * private static final String user_card =
	 * "CREATE TABLE IF NOT EXISTS User_card (\n" + "	CardId integer,\n" +
	 * " UserId integer,\n" + " PRIMARY KEY (CardId, UserId) \n," +
	 * " FOREIGN KEY (CardId) REFERENCES Card (Id) \n" +
	 * " FOREIGN KEY (UserId) REFERENCES Users (Id) \n" +");";
	 */

}
