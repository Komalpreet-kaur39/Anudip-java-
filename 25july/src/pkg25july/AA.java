/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg25july;

/**
 *
 * @author Maninder Singh
 */
public class AA extends Thread {
    public void run(){
        System.out.println("i am daemon");
            }
    public static void main(String[] args) {
        AA a=new AA();
        a.setDaemon(true);
        a.start();
//        System.out.println("i am main");
    }
}
