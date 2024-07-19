/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university;

/**
 *
 * @author Maninder Singh
 */
public class Professor {
    private String name;
    
    public Professor(String name){
    this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(){
    this.name=name;
    }
    @Override
     public String toString() {
		return "name [Name=" + name+ "]";
	}
    
    
}
