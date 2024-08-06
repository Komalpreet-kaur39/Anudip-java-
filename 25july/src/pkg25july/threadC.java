/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg25july;

public class threadC  extends Thread{
    Common c;
    String name;
    public threadC(Common c,String name){
    this.name=name;
    this.c=c;
    }
    
    @Override
    public void run(){
    c.fun(name);}
//    public static void main(String[] args) {
//        Common c=new Common();
//        Common c2=new Common();
//
//        threadC a=new threadC(c,"ram");
//        threadC b=new threadC(c2,"ramesh");
//        a.start();
//        b.start();
//
//    }
            
}
