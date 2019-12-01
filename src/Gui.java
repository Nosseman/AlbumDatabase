import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnLoad;
	
	/*String DB_URL = "jdbc:mysql://localhost:3306/albumidb";
	String USER = "root";
	String PASS = "";
	Connection conn = null;
	Statement stmt = null;*/
	
	AddWindow InsertAlbum = new AddWindow();
	RemoveWindow DeleteAlbum = new RemoveWindow();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setTitle("Albumi tietokanta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Albumin nimi");
		model.addColumn("Artisti");
		model.addColumn("Julkaisuvuosi");
		model.addColumn("Genre");
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		btnAdd = new JButton("Lis\u00E4\u00E4 albumi");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertAlbum.showWindow(InsertAlbum);
			}
		});
		btnAdd.setFont(new Font("Ink Free", Font.BOLD, 13));
		
		btnRemove = new JButton("Poista albumi");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAlbum.showWindow(DeleteAlbum);
			}
		});
		btnRemove.setFont(new Font("Ink Free", Font.BOLD, 13));
		
		btnLoad = new JButton("P\u00E4ivit\u00E4 taulukko");		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbHandler.loadDb(model);
				System.out.println("Table updated");
			}
		});
		btnLoad.setFont(new Font("Ink Free", Font.BOLD, 13));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLoad, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(92))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnRemove)
						.addComponent(btnLoad))
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
		
		DbHandler.loadDb(model);

		/*try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to database succesfully.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Albumi ORDER BY JulkaisuVuosi");

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
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
		}*/
	}
	}
