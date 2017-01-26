package it.corsojava.jdbcproject1.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.corsojava.jdbcproject1.DAOStudente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(45, 29, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome");
		lblNewLabel_1.setBounds(45, 70, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(45, 111, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(101, 26, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 67, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 108, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnPerform = new JButton("Perform");
		
		btnPerform.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome=textField.getText();
				String cognome=textField_1.getText();
				String telefono=textField_2.getText();
				boolean result=DAOStudente.insert(nome, cognome, telefono);
				if(result)
					JOptionPane.showOptionDialog(null, "Inserimento riuscito", "Successo", JOptionPane.DEFAULT_OPTION , JOptionPane.INFORMATION_MESSAGE, null, null, null);
				else
					JOptionPane.showOptionDialog(null, "Inserimento NON riuscito", "Errore", JOptionPane.DEFAULT_OPTION , JOptionPane.ERROR_MESSAGE, null, null, null);
					
			}
		});
		btnPerform.setBounds(300, 211, 89, 23);
		frame.getContentPane().add(btnPerform);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnReset.setBounds(185, 211, 89, 23);
		frame.getContentPane().add(btnReset);
	}
}
