/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coursemonitoring.system;

import Dao.*;
import DaoImplementation.AdminDaoImpl;
import Exception.*;
import Model.*;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Maninder Singh
 */
public class CourseMonitoringSystem {

   
    public static void main(String[] args) {
//        CourseMonitoringSystem ob=new CourseMonitoringSystem();
        Faculty ob=new Faculty(1,"komal","asr","2433898999","komal@gmail","kkjkm","jhj"); 
        AdminDao ob1=new AdminDaoImpl();
        try {
            String resut=ob1.registerFaculty(ob);
            System.out.println(resut);
            
        } catch (DuplicateEntryException ex) {
            Logger.getLogger(CourseMonitoringSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
