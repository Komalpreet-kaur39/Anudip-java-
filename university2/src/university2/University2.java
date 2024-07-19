/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package university2;

/**
 *
 * @author Maninder Singh
 */
public class University2 {

    private String name;
    private Department department;
    
    public University2(String name,Department department){
    this.name=name;
    this.department=department;
    }
    
    public String getname(){
    return name;
    }
    
    public Department department(){
    return department;
    }
    
    public static void main(String[] args) {
      
        Professor prof=new Professor("Komalpreet");
        Department depart=new Department("CSE",prof);
        University2 uni=new University2("AGC",depart);
        
        System.out.println("University name: " +uni.getname());
        System.out.println("Department name: "+depart.getname());
        System.out.println("Professor name :"+prof.getname());
        
    }
    
}
