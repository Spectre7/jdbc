package it.corsojava.jdbcproject1.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import it.corsojava.jdbcproject1.DBUtils;

public class JDBCUtils {
	private static JDBCUtils utils;
	private Properties prop;

	public static JDBCUtils getConnection() throws Exception{
		if(utils == null)
			utils=new JDBCUtils();
		return utils;	
	}
	
	private JDBCUtils(){
		prop= new Properties();
		try {
			prop.load(new FileInputStream(new File("application.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key){
		return prop.getProperty(key);
	}
}
