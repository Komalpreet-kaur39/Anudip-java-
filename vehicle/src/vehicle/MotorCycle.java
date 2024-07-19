/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle;

/**
 *
 * @author Maninder Singh
 */
public class MotorCycle extends Vehicle{
    @Override
    public void drive(){
        System.out.println("Wear helmet and drive on the highway");
    }
    
    public static void main(String[] args) {
        Car obj =new Car();
        obj.drive();
        MotorCycle obj1=new MotorCycle();
        obj1.drive();
        
    }
    
}
