/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university;

/**
 *
 * @author Maninder Singh
 */
public class Department {
    
    private Professor professor;
    
    public Department(Professor professor){
    this.professor=professor;
    }
    
    public Professor getprof(){
        return professor;
    }
    
    public void setProfessor(Professor professor){
    this.professor=professor;
    }
    @Override
     public String toString() {
		return "Professor [professor=" + professor + "]";
	}
    
    
}
