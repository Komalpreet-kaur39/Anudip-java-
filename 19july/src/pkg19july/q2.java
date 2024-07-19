/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg19july;
import java.util.*;

//Write a Java program that takes a list of integers as input and removes duplicates 
//using a HashSet. Then, print the resulting list.
public class q2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a number: ");
        var number=new ArrayList<Integer>();
//        while(scanner.hasNext()){
//        number.add(scanner.nextInt());
//
//        }

number.add(2);
number.add(1);
number.add(3);
number.add(4);
number.add(2);

        System.out.println(number);
        LinkedHashSet<Integer> ls=new LinkedHashSet<>((number));
        ArrayList <Integer> uniqueword=new ArrayList<>(ls);
        System.out.println("NUmber without duplicacy");
        for(int number1:uniqueword){
        System.out.println(number1);
        }
    }    
}
