package it.corsojava.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		// 1. CONNECTION
		
		// 1.a String Connection		
		String DB_URL = "jdbc:mysql://localhost:3306/corsojava";
		String DRIVER = "com.mysql.jdbc.Driver";
		String USER = "studente";
		String PASS = "studente";
		
		// 1.b Load Driver
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 2. Statement
		
		Connection conn;	
		Statement stmt;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			// 3. Execute Statement
			//String sql = "CREATE TABLE tabellaDaJava (ID INT PRIMARY KEY)";
			//stmt.executeUpdate(sql);
			
			
			// 4. ResultSet
			//stmt.executeUpdate("INSERT INTO tabellaDaJava (ID) VALUES (1)");
			//stmt.executeUpdate("INSERT INTO tabellaDaJava (ID) VALUES (2)");
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM tabellaDaJava");
			
			while(rs.next()){
				int id = rs.getInt("ID");
				System.out.println("Id trovato: " + id + "\n");
			}
			
			// 5. Close connection
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
					
		
		

		
		
		
		

		
	}

}
