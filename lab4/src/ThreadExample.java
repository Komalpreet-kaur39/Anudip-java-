/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class ThreadExample implements Runnable{
 
    //overriding the run method because we have implemented the runnable interface
    @Override
    public void run(){
        //implementing loop to print from 0 to 4
        for(int i=0;i<=4;i++)
        {
            System.out.println(i);
        }
    }
    public static void  main(String args[]){
        //initailizing PrintNum class's object
        ThreadExample p=new ThreadExample();
        //initailizing thread class's object
        Thread t=new Thread(p);
        t.start();}
    

}