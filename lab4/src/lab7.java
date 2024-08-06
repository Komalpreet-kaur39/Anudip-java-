
import static java.lang.Thread.sleep;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class lab7 implements Runnable{
    
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(i);
            try {
                sleep(500);
            } catch (InterruptedException ex) {
ex.printStackTrace();            }
        }
    }
    public static void main(String[] args) {
        lab7 ob= new lab7();
        Thread t1=new Thread(ob);
    t1.start();
    }
    
          
    
}
