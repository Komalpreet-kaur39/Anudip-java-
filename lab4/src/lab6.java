
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
class ThreadA implements Runnable{ 
@Override 
public void run() { 
    String tname=Thread.currentThread().getName(); 
for(int i=0;i<=20;i++){ 
System.out.println(tname +i); 
 
}
  System.out.println(tname+"is finished");
} 
} 
class ThreadB implements Runnable{ 
@Override 
public void run() { 
    String tname=Thread.currentThread().getName();
for(int i=21;i<=60;i++){  
System.out.println(tname +i);
} 
System.out.println(tname +" is finished "); 
} 
} 

public class lab6 { 
//public static void main(String[] args) { 
//ThreadA ta=new ThreadA(); 
//ThreadB tb=new ThreadB(); 
//
//Thread t1=new Thread(ta); 
//Thread t2=new Thread(tb);
////Thread tmain=new Thread();
//
//t1.setName("Raj"); 
//t2.setName("simran");
//
//t1.start(); 
//    try {
//        t1.join();
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//t2.start();
//    try {
//        t2.join();
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//
//    // Main thread prints numbers from 61 to 80
//
//        String tmain = Thread.currentThread().getName();
//        Thread.currentThread().setName("komal");
//        
//        for (int i = 61; i <= 80; i++) {
//            System.out.println(tmain + " " + i);
//        }
//        System.out.println(tmain + " is finished");
//   
//ThreadA ta=new ThreadA(); 
//ThreadB tb=new ThreadB(); 
//Thread t1=new Thread(ta); 
//Thread t2=new Thread(tb);
//Thread tmain=new Thread();
//t1.setName("sita"); 
//t2.setName("gita");
////tmain.setName("reema");
//t1.start(); 
//    try {
//        t1.join();
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//t2.start();
//    try {
//        t2.join();
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//    String tname = Thread.currentThread().getName();  
//
//for (int i=61;i<=80;i++){
//System.out.println(tname+i);
//}
//   }
    
     public static void main(String[] args) {
        // Create instances of each Runnable class
        ThreadA ta = new ThreadA();
        ThreadB tb = new ThreadB();

        // Create Thread objects for each Runnable instance
        Thread t1 = new Thread(ta);
        Thread t2 = new Thread(tb);
        Thread tmain=new Thread();
    

        // Set custom names for each thread
        t1.setName("Komal");
        t2.setName("Simran");

        // Start the first thread and wait for it to finish
        t1.start();
        try {
            t1.join(); // Ensure t1 completes before starting t2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the second thread and wait for it to finish
        t2.start();
        try {
            t2.join(); // Ensure t2 completes before starting t3
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //getting the name of main thread
        String tname = Thread.currentThread().getName(); 
         Thread.currentThread().setName("komal");
        //Print numbers from 61 to 80 by main thread
        for (int i=61;i<=80;i++){
            System.out.println(tname+" "+i);
         }
System.out.println(tname + " is finished"); // Indicate that this thread has finished its task
      
    }
}
    
