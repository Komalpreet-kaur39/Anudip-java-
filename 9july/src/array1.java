/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class array1 {
String name;
static String college="manit";
final  String surname ;
    public  array1(){
     surname="singh1";
        System.out.println("fjkd"); 
  
    }
 public array1(String name,String surname){
  super();
 this.name=name;
   this.surname=surname;
}
 
 final int add(int a,int b){
    return a+b;
}
// 
// final int add(int a,int b,int c){
// return a+b+c;
// }
    public static void main(String[] args) {
     
//        array1 ob=new array1("gridh");
//        System.out.println(array1.college);
//        System.out.println(ob.surname);
//        array1.college="flhdf";
//        System.out.println(array1.college);
            array1 ob4=new array1();
        array1 ob1=new array1("anu","sharma");
        System.out.println(ob1.surname);
        ob1.name="tanu";
       
        System.out.println(ob1.name);
        array1 ob2=new array1("kk","singh");
       String k= ob2.surname;
        System.out.println(k);
  
        
    
  int a=ob2.add(2,3);
        System.out.println(a);
    }
    
    
}
