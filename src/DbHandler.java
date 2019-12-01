import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class DbHandler {

	// variables for jdbc driver name, database url and credentials
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/albumidb";
	static final String USER = "root";
	static final String PASS = "";

	public static void loadDb(DefaultTableModel model) {

		Connection conn = null;
		Statement stmt = null;

		try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to database succesfully.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Albumi ORDER BY JulkaisuVuosi");

			// to update the table
			model.setRowCount(0);
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

	public static void addAlbum(Album disc) {

		String album = disc.getAlbumName();
		String artist = disc.getArtist();
		int year = disc.getYear();
		String genre = disc.getGenre();

		Connection conn = null;
		Statement stmt = null;

		try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to database succesfully.");
			stmt = conn.createStatement();

			String sql = "INSERT INTO Albumi (AlbuminNimi, Artisti, JulkaisuVuosi, Genre) values (?, ?, ?, ?)";

			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, album);
			preparedStmt.setString(2, artist);
			preparedStmt.setInt(3, year);
			preparedStmt.setString(4, genre);

			preparedStmt.execute();
			System.out.println("Saving data...\nData succesfully saved to database.");

		} catch (SQLException se) {
			System.out.println("Error when accessing database.");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error when accessing database.");
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
					System.out.println("Error when accessing database.");
					se.printStackTrace();
				}
			}
		}
	}

	public static void deleteAlbum(String album) {

		Connection conn = null;
		Statement stmt = null;

		try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to database succesfully.");
			stmt = conn.createStatement();

			String sql = "DELETE FROM Albumi WHERE AlbuminNimi='" + album + "'";
			stmt.executeUpdate(sql);

			System.out.println("Deleting album...\nAlbum succesfully deleted from database.");

		} catch (SQLException se) {
			System.out.println("Error when accessing database.");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error when accessing database.");
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
					System.out.println("Error when accessing database.");
					se.printStackTrace();
				}
			}
		}
	}
}
