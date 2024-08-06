/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg25july;



/**
 *
 * @author Maninder Singh
 */
public class threadB implements Runnable{
    int sum=0;
    public void run(){
    for(int i=0;i<=100;i++){
    sum+=i;
    }
    }
    public static void main(String[] args) {
        threadB ob=new threadB();
        Thread t1=new Thread(ob);
        t1.start();
        try {
            //        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(threadB.class.getName()).log(Level.SEVERE, null, ex);
//        }
t1.join();
        } catch (InterruptedException e) {
     e.printStackTrace();
        }
        System.out.println(ob.sum);
    }
}
