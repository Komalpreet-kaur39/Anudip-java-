/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university2;

/**
 *
 * @author Maninder Singh
 */
public class Department {
   private String name;
   private Professor professor;
   
   public Department(String name,Professor professor){
   this.name=name;
   this.professor=professor;
   }
   
   public String getname(){
   return name;
   }
   
   public Professor getprofessor(){
       return professor;
   }
    
}
