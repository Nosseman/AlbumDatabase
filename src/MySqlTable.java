import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MySqlTable {

	public static void main(String[] args) {

		String DB_URL = "jdbc:mysql://localhost:3306/albumidb";
		String USER = "root";
		String PASS = "";
		Connection conn = null;
		Statement stmt = null;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Albumin nimi");
		model.addColumn("Artisti");
		model.addColumn("Julkaisuvuosi");
		model.addColumn("Genre");

		JTable dataTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane();

		JFrame frame = new JFrame();
		frame.setTitle("Albumi tietokanta");

		frame.add(scrollPane);
		scrollPane.setViewportView(dataTable);
		
		JButton add = new JButton("Lis‰‰ albumi");	
		

		frame.pack();
		frame.setVisible(true);

		try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to database succesfully.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Albumi ORDER BY JulkaisuVuosi");

			while (rs.next()) {
				System.out
						.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
				model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4) });
			}

		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					System.out.println("Connection to database closed.");
				}
			} catch (SQLException se2) {
				try {
					if (conn != null) {
						conn.close();
						System.out.println("Connection to database closed.");
					}
				} catch (SQLException se) {
					se.printStackTrace();

				}
			}
		}
	}
}
