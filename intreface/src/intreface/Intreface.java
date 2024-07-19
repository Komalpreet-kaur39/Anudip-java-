/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package intreface;

/**
 *
 * @author Maninder Singh
 */
public abstract class Intreface implements Vehicle {

   @Override
   public void turnRight(){
       System.out.println("turn right");
   }
    public static void main(String[] args) {
       Intreface ob=new (); 
       ob.turnRight();
        
    }
    
}
