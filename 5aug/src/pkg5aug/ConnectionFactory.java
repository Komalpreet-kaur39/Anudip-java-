/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg5aug;

import java.sql.DriverManager;
import  java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Maninder Singh
 */
public class ConnectionFactory {
    
    static String url="jdbc:mysql://localhost:3306/anp8706";
    static String dname="root";
    static String dbpass="root";
    private static ConnectionFactory connection=null;
    
    private ConnectionFactory(){
    }
    
    public static ConnectionFactory getconnectionFactory(){
        if (connection==null){
            connection=new ConnectionFactory();
        }
    return connection;
    }
    
    public static Connection getConnection() throws SQLException{
    Connection  con=DriverManager.getConnection(url,dname,dbpass);
   return con;
    }
    
}
