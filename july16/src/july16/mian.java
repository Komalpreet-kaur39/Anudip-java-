/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package july16;

/**
 *
 * @author Maninder Singh
 */
public class mian {
    

     static void invalidAge(int age) throws InvalidAgeException{
    if( age>18){
    
        System.out.println("you can vote");
            }
    else{
    throw new InvalidAgeException("you cant vote");
    }
    }
public static void main(String[] args) {
        try{
            invalidAge(17);
        }catch(Exception e){
            System.out.println(e); }
    }

    }
    
    
    

