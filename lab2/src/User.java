/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;
public class User {
   static  void validateEmail(String email) throws InvalidEmailException{
    if(email.contains("@")){
        System.out.println("The Email you have entered is valid.");
        System.out.println("Your Email is "+email);
    }
    else{
    throw new InvalidEmailException("The Email you have entered  is not valid.It must have @ in the email");
    }
    }

 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the email: ");
        String email=sc.nextLine();
            
        try{
          validateEmail( email);
       }catch(Exception e){
           System.out.println(e);
       }
    }

    
}
