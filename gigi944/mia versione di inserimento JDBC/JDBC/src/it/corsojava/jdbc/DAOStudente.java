package it.corsojava.jdbc;

import java.sql.SQLException;
import java.sql.Statement;

import it.corsojava.jdbc.business.Studente;

public class DAOStudente {
	public static boolean insertStudente(Studente studente){		
		Statement statement=null;
		int res=0;
		
		try {
			statement=DBUtil.getConn().createStatement();
			res = statement.executeUpdate("INSERT INTO studenti (nome, cognome, tel) values (" + 
					"\'" + studente.getNome() + "\', " +
					"\'" + studente.getCognome() + "\', " +
					"\'" + studente.getTelefono() + "\')"
					);
		} catch (SQLException | NullPointerException e) {
			System.err.println("Errore nell'esecuzione della query");
		}
		finally{
			try {
				statement.close();
			} catch (SQLException e) {
				System.err.println("Errore nella terminazione della query");
			}
		}

		return res>0;
	}
}
