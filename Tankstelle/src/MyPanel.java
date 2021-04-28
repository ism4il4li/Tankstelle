import javax.swing.JPanel;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;





public class MyPanel extends JPanel{
	private JTextField txtVorname;
	private JTextField txtNachname;
	private JTextField textStrasse;
	private JTextField txtHausnummer;
	private JTextField textPlz;
	private JTextField txtOrt;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	
	public MyPanel() {
		setBorder(UIManager.getBorder("InternalFrame.border"));
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		this.setSize(782,526);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(Color.RED);
		panel_1.setBounds(10, 11, 303, 504);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTankLogo = new JLabel("");
		lblTankLogo.setIcon(new ImageIcon(MyPanel.class.getResource("/images/tankstelle.png")));
		lblTankLogo.setBounds(0, 0, 303, 504);
		panel_1.add(lblTankLogo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(177, 12, 0, 0);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Anmelden");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBounds(457, 414, 128, 35);
		add(btnNewButton);
		
		txtVorname = new JTextField();
		txtVorname.setFont(new Font("Arial", Font.PLAIN, 18));
		txtVorname.setBounds(532, 70, 113, 22);
		add(txtVorname);
		txtVorname.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname : ");
		lblVorname.setFont(new Font("Arial", Font.PLAIN, 18));
		lblVorname.setBounds(436, 69, 86, 25);
		add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname : ");
		lblNachname.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNachname.setBounds(419, 105, 103, 22);
		add(lblNachname);
		
		txtNachname = new JTextField();
		txtNachname.setFont(new Font("Arial", Font.PLAIN, 18));
		txtNachname.setBounds(532, 102, 113, 20);
		add(txtNachname);
		txtNachname.setColumns(10);
		
		JLabel lblStrasse = new JLabel("Strasse : ");
		lblStrasse.setFont(new Font("Arial", Font.PLAIN, 18));
		lblStrasse.setBounds(446, 138, 76, 22);
		add(lblStrasse);
		
		textStrasse = new JTextField();
		textStrasse.setFont(new Font("Arial", Font.PLAIN, 18));
		textStrasse.setBounds(532, 133, 128, 20);
		add(textStrasse);
		textStrasse.setColumns(10);
		
		JLabel lblHausnummer = new JLabel("Hausnummer : ");
		lblHausnummer.setFont(new Font("Arial", Font.PLAIN, 18));
		lblHausnummer.setBounds(401, 171, 121, 25);
		add(lblHausnummer);
		
		txtHausnummer = new JTextField();
		txtHausnummer.setFont(new Font("Arial", Font.PLAIN, 18));
		txtHausnummer.setBounds(532, 173, 86, 20);
		add(txtHausnummer);
		txtHausnummer.setColumns(10);
		
		JLabel lblPlz = new JLabel(" PLZ : ");
		lblPlz.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlz.setBounds(469, 207, 53, 22);
		add(lblPlz);
		
		textPlz = new JTextField();
		textPlz.setFont(new Font("Arial", Font.PLAIN, 18));
		textPlz.setBounds(532, 208, 86, 20);
		add(textPlz);
		textPlz.setColumns(10);
		
		JLabel lblOrt = new JLabel(" Ort : ");
		lblOrt.setFont(new Font("Arial", Font.PLAIN, 18));
		lblOrt.setBounds(476, 240, 46, 25);
		add(lblOrt);
		
		txtOrt = new JTextField();
		txtOrt.setFont(new Font("Arial", Font.PLAIN, 18));
		txtOrt.setBounds(532, 239, 113, 20);
		add(txtOrt);
		txtOrt.setColumns(10);
		
		JLabel lblTelefon = new JLabel(" Telefon : ");
		lblTelefon.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTelefon.setBounds(436, 270, 86, 20);
		add(lblTelefon);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(532, 270, 128, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel(" E-Mail : ");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmail.setBounds(446, 301, 76, 22);
		add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(532, 301, 174, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Passwort :");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPassword.setBounds(430, 334, 92, 25);
		add(lblPassword);
		
		passwordField1 = new JPasswordField();
		passwordField1.setFont(new Font("Arial", Font.PLAIN, 18));
		passwordField1.setBounds(532, 332, 174, 20);
		add(passwordField1);
		
		JLabel lblNewLabel = new JLabel("Passwort wiederholen :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(323, 360, 199, 22);
		add(lblNewLabel);
		
		passwordField2 = new JPasswordField();
		passwordField2.setFont(new Font("Arial", Font.PLAIN, 18));
		passwordField2.setBounds(532, 363, 174, 20);
		add(passwordField2);
		
		
	
		
		JPanel panel = new JPanel();
		
		
	    this.repaint();
		
		//this.repaint();
		

	}
}
