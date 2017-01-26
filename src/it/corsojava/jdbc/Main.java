package it.corsojava.jdbc;

<<<<<<< HEAD
import java.sql.Connection;
=======
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD


=======
import java.sql.Connection;
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		
		//1.Connection
		//1.A String Connection
		String DB_URL="jdbc:mysql://localhost/clienti";
		String Driver= "com.mysql.jdbc.Driver";
		String User="root";
		String Pass="root";
		//1.B Load Driver
		
		try {
			Class.forName(Driver);
=======
		// 1. CONNECTION
		
		// 1.a String Connection		
		String DB_URL = "jdbc:mysql://localhost:3306/corsojava";
		String DRIVER = "com.mysql.jdbc.Driver";
		String USER = "studente";
		String PASS = "studente";
		
		// 1.b Load Driver
		try {
			Class.forName(DRIVER);
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
<<<<<<< HEAD

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
			
=======
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
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
<<<<<<< HEAD
	
		
		//4.ResultSet
		
		
		//5.Close Connection
=======
					
		
		

		
		
		
		

		
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21
	}

}
