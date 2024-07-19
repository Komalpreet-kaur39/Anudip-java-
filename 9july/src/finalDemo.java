/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class finalDemo {
    final int maxValue=100;
    finalDemo(int maxValue){
     maxValue=200; 
        System.out.println(maxValue);
    }
    
    finalDemo(){
        System.out.println(maxValue);
    }
    public static void main(String[] args) {
        finalDemo ob1=new finalDemo();
        finalDemo ob=new finalDemo(800);
    }
    
}
