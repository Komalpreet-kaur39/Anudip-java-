/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg25july;

/**
 *
 * @author Maninder Singh
 */
public class Common {
    public synchronized void fun(String name){
        System.out.println("welcome");
        try{
        Thread.sleep(1000);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(name);
            }
    
}
