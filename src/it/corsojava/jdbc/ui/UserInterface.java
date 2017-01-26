package it.corsojava.jdbc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.corsojava.jdbc.conf.JDBCUtils;

import javax.swing.JButton;
<<<<<<< HEAD
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
=======
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class UserInterface {

	private JFrame frame;
<<<<<<< HEAD
	private JLabel label;
	private JLabel lblId;
	private JTextField textField;
=======
	private JTextField textField_1;
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21
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
		
<<<<<<< HEAD
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {  //è un ascoltatore di un qualche evento
			public void actionPerformed(ActionEvent e) {
				
				Properties properties=JDBCUtils.getAppProperties();
				
 				String DB_URL="jdbc:mysql://localhost/clienti";
				String Driver= "com.mysql.jdbc.Driver";
				
				try {
					Class.forName(Driver);
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
=======
				
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
				
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21
				
				Connection conn;
				Statement stmt;
				
				try {
<<<<<<< HEAD
					conn= DriverManager.getConnection(DB_URL,"root","root");
					stmt=conn.createStatement();
					
					String id=textField.getText();
					
					stmt.executeUpdate("insert into tabellaDaJava (ID) values ("+id+")"); //sto costruendo la stringa sql
					
					stmt.close();
					conn.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Attenzione ID esistente");
					ex.printStackTrace();
				}
				
	
			}

		
			
		});
		
		
		
		btnSave.setBounds(135, 138, 89, 23);
		frame.getContentPane().add(btnSave);
		
		label = new JLabel("");
		label.setBounds(65, 189, 46, 14);
		frame.getContentPane().add(label);
		
		lblId = new JLabel("ID");
		lblId.setBounds(133, 79, 46, 14);
		frame.getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(180, 76, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblInserimentoIdSu = new JLabel("Inserimento ID su tabellaDaJava");
		lblInserimentoIdSu.setBounds(105, 33, 244, 14);
=======
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
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21
		frame.getContentPane().add(lblInserimentoIdSu);
	}
}
