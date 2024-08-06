/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class lab8  extends Thread{
    

    private int number;

    public lab8(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(number);
    }

    public static void main(String[] args) {
          // Create an array to hold the thread references
//        lab8[] threads = new lab8[5];
        for (int i = 0; i <= 4; i++) {
            lab8 thread = new lab8(i);
            thread.start();
            
//                 threads[i] = new lab8(i);
//            threads[i].start();
        }
        
        for (int i = 0; i <= 4; i++) {
            try {
                thread[i].join(); // Main thread waits for the i-th thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

