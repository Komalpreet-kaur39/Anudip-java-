/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2aug;

/**
 *
 * @author Maninder Singh
 */
public class student {
    private int id;
    private String name;
    private int age;
    
    public student(){
    super();
    }
    
    public student(int id,String name,int age){
    this.id=id;
    this.name=name;
    this.age=age;
    }
    
    public int getid(int id){
    return id;
    }
    
    public String getname(String name){
    return name;
    }
    
    public int getage(int age){
    return age;
    }
    
    @Override
    public String toString(){
    return "Student id :"+id+" "+"Student name :"+name+" "+"Student age :"+age;
    }
}
