/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg25july;

/**
 *
 * @author Maninder Singh
 */
public class ThreadA extends Thread {

 @Override
 public void run(){
 
 }
    public static void main(String[] args) {
        System.out.println("Main thread :"+Thread.currentThread().getPriority());  
       ThreadA t1=new ThreadA();
        ThreadA t2=new ThreadA();
        ThreadA t3=new ThreadA(); 
        
        System.out.println("Priority of t1 :"+t1.getPriority());
        System.out.println("Priority of t1 :"+t2.getPriority());
        System.out.println("Priority of t1 :"+t3.getPriority());
        t1.setPriority(5);
        t2.setPriority(6);
        t3.setPriority(10);
        System.out.println("-=---------------------");
        System.out.println("Priority of t1 :"+t1.getPriority());
        System.out.println("Priority of t1 :"+t2.getPriority());
        System.out.println("Priority of t1 :"+t3.getPriority());

    }
    
}
