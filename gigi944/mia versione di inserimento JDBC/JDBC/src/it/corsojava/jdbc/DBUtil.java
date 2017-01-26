package it.corsojava.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static Connection conn= null;
	
	public static Properties getAppProperties(){
		Properties properties = new Properties();
		InputStream in = null;
		try {
			in = new FileInputStream(new File("./application.properties"));
			properties.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return properties;
	}

	public static Connection getConn() {
		
		if(conn==null){		
			/*String dbUrl = "jdbc:mysql://localhost/clienti";
			String driver = "com.mysql.jdbc.Driver";
			String user = "root";
			String pass = "root";*/
			Properties properties = getAppProperties();
			try {
				Class.forName(properties.getProperty("driver"));
				conn=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("pass"));
			
			} catch (SQLException e1) {
				System.err.println("Errore di connessione al DB");
				System.err.println("Causa: " + e1.getMessage());
			} catch (ClassNotFoundException e) {
				System.err.println("Errore: driver non trovato");
			}
		}
		return conn;
	}
	
	public static void closeConn(){
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Errore nella chiusura della connessione al DB");
			}
		conn=null;
	}
	
}
