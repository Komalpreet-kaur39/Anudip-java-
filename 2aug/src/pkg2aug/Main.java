/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2aug;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maninder Singh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
		}
        try {
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anp8706" ,"root", "root") ;
			
// step 3 	
	Statement st  = con.createStatement();
			// step 4  
	ResultSet  rs  = st.executeQuery("select * from Student") ;
			
	while(rs.next()) {
		System.out.println(   "student "+ rs.getInt(1) +" " +rs.getString(2 )+" " +rs.getInt(3) );
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
}
