package it.corsojava.jdbcproject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import it.corsojava.jdbcproject1.conf.JDBCUtils;

public class DBUtils {
	private static final String DB_URL = "jdbc:mysql://localhost/clienti";
	private static final String DB_USER = "root";
	private static final String DB_PWD = "root";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static DBUtils dbUtils;
	private Connection connection = null;

	public static DBUtils getConnection() throws Exception{
		if(dbUtils == null)
			dbUtils=new DBUtils();
		return dbUtils;	
	}
	
	private DBUtils() throws Exception{
		
		//System.out.println("-->"+prop.getProperty("driver"));
		JDBCUtils propManager=JDBCUtils.getConnection();
		Class.forName(propManager.getProperty("driver"));
		connection=DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
		
	}
	
	public Statement getStatement() throws SQLException{
		return connection.createStatement();
	}
	
	public void closeConnection() throws SQLException{
		connection.close();
	}
}
