package it.corsojava.jdbc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.corsojava.jdbc.conf.JDBCUtils;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class UserInterface {

	private JFrame frame;
	private JTextField textField_1;
	private JLabel lblInserimentoIdSu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
				
		JButton btnSave = new JButton("Save");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Properties properties = JDBCUtils.getAppProperties();
								
				String DB_URL=properties.getProperty("url");
				String Driver= properties.getProperty("driver");
		
				try {
					Class.forName(Driver);
				} catch (ClassNotFoundException ex) {					
					ex.printStackTrace();
				}			
				
				
				Connection conn;
				Statement stmt;
				
				try {
					conn= DriverManager.getConnection(DB_URL,"studente","studente");
					stmt=conn.createStatement();
					
					String id = textField_1.getText();
					
					stmt.executeUpdate("Insert into tabellaDaJava (ID) values ( " + id  + " )");			
					
										
					stmt.close();
					conn.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Attenzione ID esistente");					
				}

				
				frame.dispose();
			}
		
		});

		
		btnSave.setBounds(159, 146, 117, 25);
		frame.getContentPane().add(btnSave);
		
		JLabel lblCognome = new JLabel("ID");
		lblCognome.setBounds(121, 80, 19, 25);
		frame.getContentPane().add(lblCognome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 83, 143, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblInserimentoIdSu = new JLabel("Inserimento ID su tabellaDaJava");
		lblInserimentoIdSu.setBounds(93, 29, 237, 15);
		frame.getContentPane().add(lblInserimentoIdSu);
	}
}
