package it.corsojava.jdbcproject1;

import java.sql.Statement;

public class DAOStudente {
	
	public static boolean insert(String nome, String cognome, String telefono){
		
		boolean result=false;
		try {
			DBUtils util= DBUtils.getConnection();
			Statement statement = util.getStatement();
			statement.executeUpdate("insert into studente values ('"+nome+"','"+cognome+"','"+telefono+"');");
			statement.close();
			util.closeConnection();
			result=true;
		} catch (Exception e) {	}
		return result;
	}
}
