package it.corsojava.jdbcproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Main {
	
	private static final String DB_URL = "jdbc:mysql://localhost/clienti";
	private static final String DB_USER = "root";
	private static final String DB_PWD = "root";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName(DB_DRIVER);
		Connection connection = null;
		Statement statement=null;
		try {
			connection=DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			statement=connection.createStatement();
			String sqlcmd= "CREATE TABLE javatable (col1 int)";
			//statement.executeUpdate(sqlcmd);
			
			//for(int i=2;i<10;i++){
			//	String sqlInsert="insert into javatable values("+i+");";
			//	statement.executeUpdate(sqlInsert);
			//}
			
			ResultSet rs=statement.executeQuery("Select * from javatable");
			
			while(rs.next()){
				int id=rs.getInt(1);
				System.out.println("Valore letto --> "+id);
			}
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
