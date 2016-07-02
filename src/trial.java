import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Slice {
	double value;
	Color color;

	public Slice(double value, Color color) {
		this.value = value;
		this.color = color;
	}
}

class MyComponent extends JComponent {
	
	
	Slice[] slices = { new Slice(33, Color.green), new Slice(15, Color.red) };
	private Connect connect;
	private static final String RETRIEVE_TOTAL = "Select * from Preference Where UId = ? ";
	private static final String RETRIEVE_CAL = "Select * from Tracker Where UId = ? and Tdate = ? ";

	MyComponent() {
		connect = new Connect();
	}

	public void paint(Graphics g) {
		drawPie((Graphics2D) g, getBounds(), slices);
	}

	void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		int x = getCal(1);
		double total = getTotal(1);
		System.out.println(x + " " + total);

		for (int i = 0; i < slices.length; i++) {
			total += slices[i].value;
		}

		double curValue = 0.0D;
		int startAngle = 0;
		for (int i = 0; i < slices.length; i++) {
			startAngle = (int) (curValue * 360 / total);
			int arcAngle = (int) (x * 360 / total);

			g.setColor(slices[i].color);
			g.fillArc(200, 200, 300, 300, startAngle, arcAngle);
			g.setColor(Color.BLACK);
			if (i == 0) {
				//g.drawString("Calories Gained:", 350, 280);
				g.drawString("" + numberFormat.format((x / total) * 100)+ "%", 375, 295);
			}
			else {
				//g.drawString("Calories Remaining :", 250, 410);
				g.drawString("" +numberFormat.format((x / total)* 100) + "%", 380, 410);
			}
			
			curValue += (x);
			x = (int) (total - x);
		}
	}

	public int getTotal(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		int x = 0;
		try {
			con = connect.connect();
			ps = con.prepareStatement(RETRIEVE_TOTAL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				x = rs.getInt(3);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}
		return x;
	}

	public int getCal(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		int x = 0;
		try {
			con = connect.connect();
			ps = con.prepareStatement(RETRIEVE_CAL);
			ps.setInt(1, id);
			ps.setString(2, "2016-06-01");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				x = rs.getInt(3);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			connect.closeStatement(ps);
			connect.closeConnection(con);

		}
		return x;
	}

}
