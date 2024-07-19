/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

/**
 *
 * @author Maninder Singh
 */
public class Dog extends Animal{
    public void sound(){
        System.out.println("the dog barks");}
    
    public static void main(String []a){
     Dog ob=new Dog();
     ob.sound();
    }
    
}
