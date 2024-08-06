/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg26july;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maninder Singh
 */
public class Main extends Thread {
    int sum =0;
    public void run(){
        synchronized(this){
            System.out.println("starting calculation");
        for(int i=0;i<=100;i++){
            sum+=i;
        }
            System.out.println("it is giving notificaton");
        this.notify();
    }
    }
    public static void main(String[] args) {
       Main ob=new Main();
       ob.start();
       synchronized(ob){
           try {
               ob.wait();
           } catch (InterruptedException ex) {
               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
           }
        
       
        System.out.println(ob.sum);
     
    }
    }
}
