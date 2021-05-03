import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kraftstoff.Zapfsaule1;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;


public class Zapfsaele1Frame extends JFrame {
	
	Zapfsaule1 zapfsaele1;
	private JPanel contentPane;
	private JRadioButton rdbtnBenzinE10;
	private JRadioButton rdbtnBenzin95;
	private JRadioButton rdbtnSuperPlus;
	private JRadioButton rdbtnDiesel;
	private JRadioButton rdbtnTruckDiesel;
	private JRadioButton rdbtnAutogas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zapfsaele1Frame frame = new Zapfsaele1Frame();
					frame.setLocationRelativeTo(null);
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
	public Zapfsaele1Frame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 657, 307);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		comboBox.setBounds(280, 157, 66, 37);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = (String) comboBox.getSelectedItem();
				if(rdbtnBenzinE10.isSelected()) {
				for(int i=0; i < Integer.parseInt(value);i++) {
					Zapfsaule1.benzinE10();
					
					}System.out.println(value+" Liter Benzin E10 getankt");
				}else if(rdbtnBenzin95.isSelected()) {
						for(int i=0; i < Integer.parseInt(value);i++) {
							Zapfsaule1.benzin95();
							}System.out.println(value+" Liter Benzin95 getankt");
					}else if(rdbtnSuperPlus.isSelected()) {
						for(int i=0; i < Integer.parseInt(value);i++) {
							Zapfsaule1.benzinSuperPlus();
							}System.out.println(value+" Liter Super-Plus getankt");
					}else if(rdbtnDiesel.isSelected()) {
						for(int i=0; i < Integer.parseInt(value);i++) {
							Zapfsaule1.diesel();
							}System.out.println(value+" Liter Diesel getankt");
					}else if(rdbtnTruckDiesel.isSelected()) {
						for(int i=0; i < Integer.parseInt(value);i++) {
							Zapfsaule1.truckDiesel();
							}System.out.println(value+" Liter LKW Diesel getankt");
					}else if(rdbtnAutogas.isSelected()) {
						for(int i=0; i < Integer.parseInt(value);i++) {
							Zapfsaule1.autogas();
							}System.out.println(value+" Liter Autogas getankt");
					}else {
						JOptionPane.showMessageDialog(null,"Ein Treibstoff auswählen!");
					}
			}
		});
		btnNewButton.setBounds(281, 233, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Zapfs\u00E4ule 1");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(260, 27, 151, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("W\u00E4hle die Menge in Liter :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 154, 218, 37);
		panel.add(lblNewLabel_1);
		
		rdbtnBenzinE10 = new JRadioButton("BenzinE10");
		rdbtnBenzinE10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnBenzinE10.isSelected()) {
					rdbtnBenzin95.setSelected(false);
					rdbtnSuperPlus.setSelected(false);
					rdbtnDiesel.setSelected(false);
					rdbtnTruckDiesel.setSelected(false);
					rdbtnAutogas.setSelected(false);
				}
			}
		});
		rdbtnBenzinE10.setBounds(6, 77, 89, 23);
		panel.add(rdbtnBenzinE10);
		
		rdbtnBenzin95 = new JRadioButton("Benzin95");
		rdbtnBenzin95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnBenzin95.isSelected()) {
					rdbtnBenzinE10.setSelected(false);
					rdbtnSuperPlus.setSelected(false);
					rdbtnDiesel.setSelected(false);
					rdbtnTruckDiesel.setSelected(false);
					rdbtnAutogas.setSelected(false);
				}
			}
		});
		rdbtnBenzin95.setBounds(113, 77, 89, 23);
		panel.add(rdbtnBenzin95);
		
		rdbtnSuperPlus = new JRadioButton("SuperPlus");
		rdbtnSuperPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnSuperPlus.isSelected()) {
					rdbtnBenzinE10.setSelected(false);
					rdbtnBenzin95.setSelected(false);
					rdbtnDiesel.setSelected(false);
					rdbtnTruckDiesel.setSelected(false);
					rdbtnAutogas.setSelected(false);
				}
				
			}
		});
		rdbtnSuperPlus.setBounds(212, 77, 89, 23);
		panel.add(rdbtnSuperPlus);
		
		rdbtnDiesel = new JRadioButton("Diesel");
		rdbtnDiesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDiesel.isSelected()) {
					rdbtnBenzinE10.setSelected(false);
					rdbtnBenzin95.setSelected(false);
					rdbtnSuperPlus.setSelected(false);
					rdbtnTruckDiesel.setSelected(false);
					rdbtnAutogas.setSelected(false);
				}
				
			}
		});
		rdbtnDiesel.setBounds(311, 77, 76, 23);
		panel.add(rdbtnDiesel);
		
		rdbtnTruckDiesel = new JRadioButton("TruckDiesel");
		rdbtnTruckDiesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnTruckDiesel.isSelected()) {
					rdbtnBenzinE10.setSelected(false);
					rdbtnBenzin95.setSelected(false);
					rdbtnSuperPlus.setSelected(false);
					rdbtnDiesel.setSelected(false);
					rdbtnAutogas.setSelected(false);
				}
			}
		});
		rdbtnTruckDiesel.setBounds(407, 77, 89, 23);
		panel.add(rdbtnTruckDiesel);
		
		rdbtnAutogas = new JRadioButton("Autogas");
		rdbtnAutogas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAutogas
						.isSelected()) {
					rdbtnBenzinE10.setSelected(false);
					rdbtnBenzin95.setSelected(false);
					rdbtnSuperPlus.setSelected(false);
					rdbtnDiesel.setSelected(false);
					rdbtnTruckDiesel.setSelected(false);
				}
				
			}
		});
		rdbtnAutogas.setBounds(506, 77, 79, 23);
		panel.add(rdbtnAutogas);
	}
}
