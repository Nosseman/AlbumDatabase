import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAlbum;
	private JTextField albumField;
	private JLabel lblArtist;
	private JLabel lblYear;
	private JTextField artistField;
	private JTextField yearField;
	private JLabel lblGenre;
	private JTextField genreField;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWindow frame = new AddWindow();
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
	public AddWindow() {
		setTitle("Lis\u00E4\u00E4 albumi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 237);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowWeights = new double[]{0, 0, 0, 0, 0, 0};
		contentPane.setLayout(gbl_contentPane);
		
		lblAlbum = new JLabel("Albumin nimi:");
		lblAlbum.setFont(new Font("Ink Free", Font.BOLD, 13));
		GridBagConstraints gbc_lblAlbum = new GridBagConstraints();
		gbc_lblAlbum.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlbum.gridx = 3;
		gbc_lblAlbum.gridy = 0;
		contentPane.add(lblAlbum, gbc_lblAlbum);
		
		albumField = new JTextField();
		GridBagConstraints gbc_albumField = new GridBagConstraints();
		gbc_albumField.gridwidth = 4;
		gbc_albumField.insets = new Insets(0, 0, 5, 5);
		gbc_albumField.fill = GridBagConstraints.HORIZONTAL;
		gbc_albumField.gridx = 4;
		gbc_albumField.gridy = 0;
		contentPane.add(albumField, gbc_albumField);
		albumField.setColumns(10);
		
		lblArtist = new JLabel("Artisti:");
		lblArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtist.setFont(new Font("Ink Free", Font.BOLD, 13));
		GridBagConstraints gbc_lblArtist = new GridBagConstraints();
		gbc_lblArtist.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtist.gridx = 3;
		gbc_lblArtist.gridy = 1;
		contentPane.add(lblArtist, gbc_lblArtist);
		
		artistField = new JTextField();
		GridBagConstraints gbc_artistField = new GridBagConstraints();
		gbc_artistField.gridwidth = 4;
		gbc_artistField.insets = new Insets(0, 0, 5, 5);
		gbc_artistField.fill = GridBagConstraints.HORIZONTAL;
		gbc_artistField.gridx = 4;
		gbc_artistField.gridy = 1;
		contentPane.add(artistField, gbc_artistField);
		artistField.setColumns(10);
		
		lblYear = new JLabel("Julkaisuvuosi:");
		lblYear.setFont(new Font("Ink Free", Font.BOLD, 13));
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear.gridx = 3;
		gbc_lblYear.gridy = 2;
		contentPane.add(lblYear, gbc_lblYear);
		
		yearField = new JTextField();
		GridBagConstraints gbc_yearField = new GridBagConstraints();
		gbc_yearField.gridwidth = 4;
		gbc_yearField.insets = new Insets(0, 0, 5, 5);
		gbc_yearField.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearField.gridx = 4;
		gbc_yearField.gridy = 2;
		contentPane.add(yearField, gbc_yearField);
		yearField.setColumns(10);
		
		lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Ink Free", Font.BOLD, 13));
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenre.gridx = 3;
		gbc_lblGenre.gridy = 3;
		contentPane.add(lblGenre, gbc_lblGenre);
		
		genreField = new JTextField();
		GridBagConstraints gbc_genreField = new GridBagConstraints();
		gbc_genreField.gridwidth = 4;
		gbc_genreField.insets = new Insets(0, 0, 5, 5);
		gbc_genreField.fill = GridBagConstraints.HORIZONTAL;
		gbc_genreField.gridx = 4;
		gbc_genreField.gridy = 3;
		contentPane.add(genreField, gbc_genreField);
		genreField.setColumns(10);
		
		btnSave = new JButton("Tallenna");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAlbum();
			}
		});
		btnSave.setFont(new Font("Ink Free", Font.BOLD, 13));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 4;
		gbc_btnSave.gridy = 5;
		contentPane.add(btnSave, gbc_btnSave);
	}

	public void showWindow(AddWindow aw) {
		aw.setVisible(true);
	}
	
	protected void saveAlbum() {
		// variables from the input fields
		String albumName = albumField.getText();
		String artist = artistField.getText();
		String year = yearField.getText();
		String genre = genreField.getText();
		// new album object
		if(albumName.isEmpty() || artist.isEmpty() || year.isEmpty() || genre.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Täytä kaikki kentät!", "Virhe!", JOptionPane.WARNING_MESSAGE);
			
		} else {
		Album newAlbum = new Album(albumName, artist, Integer.parseInt(year), genre);
		
		//using the DbHandler functions to save into database
		DbHandler.addAlbum(newAlbum);
		JOptionPane.showMessageDialog(this, "Tallennettu");
		setVisible(false);
		}
		

	}

}
