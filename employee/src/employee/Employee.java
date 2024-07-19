/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employee;

public class Employee {
 String name="abc";
        String dept="cse";
        int id=12;
        int sal=12300;
    
     Employee(){
         System.out.println("info about employee");
     }
     Employee(int id,int sa1,String name,String dept){
       this.id=id;
       this.name=name;
       this.sal=sal;
       this.dept=dept;
     }
     public void display(){
           System.out.println(name);
           System.out.println(id);
           System.out.println(sal);
           System.out.println(dept);
           
     }
    public static void main(String[] args) {
       Employee obj=new Employee(1,1200,"abc","cse");
       obj.display();
    }
    
}
