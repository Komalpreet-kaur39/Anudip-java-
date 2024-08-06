/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class demo {
    public static void main(String[] args) {
        
        Thread1 ob=new Thread1();
        ob.start();
        
        th2 ob1=new th2();
        Thread th=new Thread (ob1);
        th.start();
        
        for(int i=21;i<=40;i++){
            System.out.println("main--"+i);
        }
    }
    
}
