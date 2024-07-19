/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package july16;

/**
 *
 * @author Maninder Singh
 */
public class InvalidAgeException extends Exception {
    
    public InvalidAgeException(){
    }
    public InvalidAgeException(String msg){
//        System.out.println(msg);
super(msg);
    }
}
