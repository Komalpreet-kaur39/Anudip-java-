/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg19july;

import java.util.*;

/**
 *
 * @author Maninder Singh
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String words[]=sentence.split(" ");
        
        
    HashSet<String> hs=new HashSet<String>(Arrays.asList(words));
//        System.out.println(hs);   
    ArrayList <String> uniqueword=new ArrayList<String>(hs);
    Collections.sort(uniqueword);
        System.out.println("Sorted words:");
    for(String sortedword:uniqueword){
        System.out.println(sortedword);
    
    }
        

    }
    
}
