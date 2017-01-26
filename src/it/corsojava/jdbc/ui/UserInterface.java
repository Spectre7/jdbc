package it.corsojava.jdbc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.corsojava.jdbc.conf.JDBCUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class UserInterface {

	private JFrame frame;
	private JLabel label;
	private JLabel lblId;
	private JTextField textField;
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
				
				Connection conn;
				Statement stmt;
				
				try {
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
		frame.getContentPane().add(lblInserimentoIdSu);
	}
}
