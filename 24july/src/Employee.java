/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class Employee {
    int id;
    String name;
    double salary;
    
    Employee(int id,String name,double salary ){
    this.id=id;
        this.name=name;
    this.salary=salary;
    }

    @Override
    public String toString(){
        return "Employee[Id:"+id+" Name:"+name+" Salary:"+salary+"]";
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
