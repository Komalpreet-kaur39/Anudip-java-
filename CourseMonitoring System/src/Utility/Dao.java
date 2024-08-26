package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
 // siglton class 
	   private static final String url  = "jdbc:mysql://localhost:3306/coursemonitoring";
	   private static final String dbname  = "root" ;
	   private static final String dbpass  = "WJ28@krhps" ;
		
	private Dao() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
        }

	private static Dao  connectionFactory = null  ;

	public static Dao getConnectionFactory() {
		if ( connectionFactory  ==  null) {
                    connectionFactory   = new  Dao() ;
                }
		return connectionFactory ;
	}
	// method to get connection from this singleton class 
	public Connection getConnection() throws SQLException {	
		Connection con = DriverManager.getConnection(url, dbname, dbpass) ;
                return con  ;
		
	}
	
}
