/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class Thread1 extends Thread {
    @Override
    public void run(){
        
        for(int i=0;i<20;i++){
            System.out.println("Thread--"+i);
        }
    }
    public static void main(String[] args) {
        Thread1 ob=new Thread1();
        ob.run();
    }
    
}
