  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstract1;

/**
 *
 * @author Maninder Singh
 */
public class PartTime extends Employee{
    private double hourlyrate;
    public PartTime(double hourlyrate){
    this.hourlyrate=hourlyrate;
    }
    public double calculateSalary(){
    return hourlyrate;
    }
    public static void main(String[] args) {
        FullTime ob= new FullTime(400);
        PartTime ob1=new PartTime (3000);
        System.out.println("FullTime employee salary: "+ob.calculateSalary());
        System.out.println("PartTime employee salary: "+ob1.calculateSalary());
    }
    
}
