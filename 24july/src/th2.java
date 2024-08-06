/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class th2 implements Runnable{

    @Override
    public void run() {
        System.out.println("hello");
    }
    public static void main(String[] args) {
        th2 ob=new th2() ;
          Thread t1=new Thread(ob);
t1.start();
t1.setName("komal");
   
    }
    
    
}
