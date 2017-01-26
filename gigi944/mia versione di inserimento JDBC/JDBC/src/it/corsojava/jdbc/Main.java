package it.corsojava.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		String dbUrl = "jdbc:mysql://localhost/clienti";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String pass = "root";
		
		Connection conn=null;
		Statement statement=null;

		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dbUrl, user, pass);
			statement=conn.createStatement();
		} catch (SQLException e1) {
			System.err.println("Errore di connessione al DB");
			System.err.println("Causa: " + e1.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Errore: driver non trovato");
		}
		
		String sql = null;
		ResultSet res=null;
		//sql = "CREATE TABLE tabellaDaJava(ID int auto_increment primary key)";
		try {
			//statement.executeUpdate("INSERT INTO tabelladajava (ID) values(1)");
			//statement.executeUpdate("INSERT INTO tabelladajava (ID) values(2)");
			//statement.executeUpdate("INSERT INTO tabelladajava (ID) values(3)");
			res = statement.executeQuery("SELECT * FROM tabelladajava");
			while(res.next())
				System.out.println("ID:\t" + res.getInt("ID"));
		} catch (SQLException e) {
			System.err.println("Errore nell'esecuzione della query: " + sql);
			System.err.println("Causa: " + e.getMessage());
		}
		
		
		
		try {
			statement.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Errore nella chiusura della connessione");
			System.err.println("Causa: " + e.getMessage());
		}
		
	}

}
