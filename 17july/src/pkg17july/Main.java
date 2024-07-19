/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg17july;

public class Main {

    public static void p(){
        System.out.println("top p");
                
        int data=12/0;
        System.out.println("b p");
    }
    public static void n(){
        System.out.println("top n");
                
        p();
        System.out.println("b n");
        
    }

     public static void m(){
    
            System.out.println("top m");
//            try{
            n();
//            }catch(Exception e){
//                System.out.println(e);
//            }
            System.out.println("b m");
}
    public static void main(String[] args) {
 m();
}}
