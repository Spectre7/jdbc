package it.corsojava.jdbc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import it.corsojava.jdbc.DBUtil;
import it.corsojava.jdbc.DAOStudente;
import it.corsojava.jdbc.business.Studente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterface {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldTel;
	private JLabel lblCognome;
	private JLabel lblTel;

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
		DBUtil.closeConn();
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
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(174, 34, 86, 20);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setBounds(174, 65, 86, 20);
		frame.getContentPane().add(textFieldCognome);
		textFieldCognome.setColumns(10);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(174, 96, 86, 20);
		frame.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome=textFieldNome.getText();
				String cognome=textFieldCognome.getText();
				String tel=textFieldTel.getText();
				tel = tel.replaceAll("\\D+","");
				Studente studente=new Studente(nome, cognome, tel);
				boolean esito=DAOStudente.insertStudente(studente);
				String message=null;
				if(esito)
					message="studente " + studente.getNome() + " salvato!";
				else
					message="ERRORE: studente " + studente.getNome() + " non salvato!";
				JOptionPane.showMessageDialog(frame, message);
			}
		});
		btnSalva.setBounds(225, 142, 89, 23);
		frame.getContentPane().add(btnSalva);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldNome.setText("");
				textFieldCognome.setText("");
				textFieldTel.setText("");
			}
		});
		btnReset.setBounds(126, 142, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(118, 37, 46, 14);
		frame.getContentPane().add(lblNome);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setBounds(106, 68, 58, 14);
		frame.getContentPane().add(lblCognome);
		
		lblTel = new JLabel("Tel:");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setBounds(118, 99, 46, 14);
		frame.getContentPane().add(lblTel);
	}
}
