package it.corsojava.jdbc.conf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

<<<<<<< HEAD
public class JDBCUtils { 
	
	
	public static Properties getAppProperties (){
		Properties defaultProps= new Properties();
		FileInputStream in;
		try{
			in= new FileInputStream ("application.properties");
			defaultProps.load(in);
			in.close();
					
					
					
		}catch(FileNotFoundException e){
					e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return defaultProps;
		
	}

=======
public class JDBCUtils {
	public static Properties getAppProperties() {
		// create and load default properties
		
		Properties defaultProps = new Properties();
		
		FileInputStream in;
		try {
			in = new FileInputStream("application.properties");
			defaultProps.load(in);
			in.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return defaultProps;
	}
>>>>>>> 700187457e1b6f403d25de01a6add0c254963a21
}
