import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.SQLiteConnection;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login_Kasse extends JFrame {

	private JPanel contentPane;
	private JTextField textBenutzername;
	//private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Kasse frame = new Login_Kasse();
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
	Connection connection = null;
	private JPasswordField textPasswort;
	public Login_Kasse() {
		connection = SQLiteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 470);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 707, 415);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBenutzername = new JLabel("Benutzername :");
		lblBenutzername.setFont(new Font("Arial", Font.PLAIN, 18));
		lblBenutzername.setBounds(85, 66, 132, 32);
		panel.add(lblBenutzername);
		
		textBenutzername = new JTextField();
		textBenutzername.setFont(new Font("Arial", Font.PLAIN, 18));
		textBenutzername.setBounds(261, 66, 211, 32);
		panel.add(textBenutzername);
		textBenutzername.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort :");
		lblPasswort.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPasswort.setBounds(119, 165, 98, 22);
		panel.add(lblPasswort);
		
		JButton btnEinloggen = new JButton("Einloggen");
		btnEinloggen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from Mitarbeiter where Benutzername=? and Passwort=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textBenutzername.getText());
					pst.setString(2, textPasswort.getText());
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count++;
						
					}
					if(count==1) {
						//JOptionPane.showMessageDialog(null, "login war erfolgreich");
						
						dispose();
						Kasse_Bildschirm ks = new Kasse_Bildschirm();
						ks.setVisible(true);
						
						
					}else if(count >1) {
						JOptionPane.showMessageDialog(null, "doppelt");
					}else {
						JOptionPane.showMessageDialog(null, "Benutzername oder Passwort falsch");
					}
					rs.close();
					pst.close();
					
				}catch(Exception ex) {
					System.out.println(ex);
					//JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		btnEinloggen.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEinloggen.setBounds(241, 296, 169, 44);
		panel.add(btnEinloggen);
		
		textPasswort = new JPasswordField();
		textPasswort.setEchoChar('*');
		textPasswort.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPasswort.setBounds(261, 156, 211, 32);
		panel.add(textPasswort);
	}
}
