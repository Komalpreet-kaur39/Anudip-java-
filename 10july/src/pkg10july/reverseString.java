/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg10july;


public class reverseString {

    
    public static void main(String[] args) {
        
     String s =new String("komalpreet");
   int i; 
   String s1="";
   int j=s.length();
for ( i=j;i>0;i--){
            System.out.println(s1.charAt(i));
    
    
}   
String originalString = "Hello";
String reversedString = "";
int k;
for ( k = 0; k < originalString.length(); k++) {
  reversedString = originalString.charAt(k) + reversedString;
}

System.out.println("Reversed string: "+ reversedString);

}
}
