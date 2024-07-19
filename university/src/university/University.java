/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package university;

/**
 *
 * @author Maninder Singh
 */
public class University {

  private Department department;
  
  public University(Department department){
  this.department=department;
  }
  
  public Department getDepart(){
   return department;
  }
  
  public void setdepart(Department department){
   this.department=department;
  }
  @Override
  public String toString() {
		return "Depatment [Department=" + department + "]";
	}

  
  public static void main (String[] a){
  Professor pro=new Professor("komal"); 
  Department dept=new Department(pro);
  University uni=new University(dept);
  
      System.out.println(" Professor name : " +uni.getDepart().getprof().getName());
  }
}
