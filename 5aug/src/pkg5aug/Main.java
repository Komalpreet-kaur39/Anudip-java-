/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg5aug;

import com.sun.jdi.connect.spi.Connection;

public class Main {
    public void addStudent(){
      Connection c=ConnectionFactory.getconnectionFactory().getConnection();
      PreparedStatement ppst=c.prepareStatment("insert into")
     ppst.setInt(1,s.getid());
     ppst.setString(2,s.getname());
     int ans=ppst.executeUpdate();
     
     if(ans!=0){
         System.out.println("data inserted");
     }
    }
    
    public static void main(String[] args) {
        
        Main ob=new Main();
       ob.addStudent(new Student);
    }
    
}
