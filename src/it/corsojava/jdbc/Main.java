package it.corsojava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Main {

	public static void main(String[] args) {
		
		//1.Connection
		//1.A String Connection
		String DB_URL="jdbc:mysql://localhost/clienti";
		String Driver= "com.mysql.jdbc.Driver";
		String User="root";
		String Pass="root";
		//1.B Load Driver
		
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		//2.Statement
		Connection conn;
		Statement stmt;
		
		try {
			conn= DriverManager.getConnection(DB_URL,"root","root");
			stmt=conn.createStatement();
			
			//3.Execute Statement
			//String sql = "CREATE TABLE tabellaDaJava (ID INT Primary key)";
			//stmt.executeUpdate(sql);
			
			//4.ResultSet
			//stmt.executeUpdate("Insert into tabellaDaJava (ID) values (1)");
			//stmt.executeUpdate("Insert into tabellaDaJava (ID) values (2)");
			
			ResultSet rs= stmt.executeQuery("SELECT* FROM tabellaDaJava");
		
			while (rs.next()){
				int id=rs.getInt("ID");
				System.out.println("id trovato:"+id+"\n");
			}
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		//4.ResultSet
		
		
		//5.Close Connection
	}

}
