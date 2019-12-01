import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAlbumName;
	private JTextField albumField;
	private JButton btnPoista;

	/**
	 * Create the frame.
	 */
	public RemoveWindow() {
		setTitle("Poista albumi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 175);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0, 0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowWeights = new double[]{0, 0, 0, 0, 0.0, 0, 0, 0, 0, 0};
		contentPane.setLayout(gbl_contentPane);
		
		lblAlbumName = new JLabel("Albumin nimi:");
		lblAlbumName.setFont(new Font("Ink Free", Font.BOLD, 13));
		GridBagConstraints gbc_lblAlbumName = new GridBagConstraints();
		gbc_lblAlbumName.gridwidth = 2;
		gbc_lblAlbumName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlbumName.gridx = 5;
		gbc_lblAlbumName.gridy = 4;
		contentPane.add(lblAlbumName, gbc_lblAlbumName);
		
		albumField = new JTextField();
		GridBagConstraints gbc_albumField = new GridBagConstraints();
		gbc_albumField.gridwidth = 3;
		gbc_albumField.insets = new Insets(0, 0, 5, 5);
		gbc_albumField.fill = GridBagConstraints.HORIZONTAL;
		gbc_albumField.gridx = 7;
		gbc_albumField.gridy = 4;
		contentPane.add(albumField, gbc_albumField);
		albumField.setColumns(10);
		
		btnPoista = new JButton("Poista");
		btnPoista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAlbum();
			}
		});
		btnPoista.setFont(new Font("Ink Free", Font.BOLD, 13));
		GridBagConstraints gbc_btnPoista = new GridBagConstraints();
		gbc_btnPoista.insets = new Insets(0, 0, 5, 5);
		gbc_btnPoista.gridx = 7;
		gbc_btnPoista.gridy = 6;
		contentPane.add(btnPoista, gbc_btnPoista);
	}
	
	public void showWindow(RemoveWindow dw) {
		dw.setVisible(true);
	}
	
	protected void removeAlbum() {
		String albumName = albumField.getText();

		if (albumName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Anna poistettavan albumin nimi", "Virhe!",
					JOptionPane.WARNING_MESSAGE);

		} else {
			DbHandler.deleteAlbum(albumName);
			JOptionPane.showMessageDialog(this, "Poistettu");
			setVisible(false);
		}
	}
}
