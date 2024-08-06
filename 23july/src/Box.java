/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class Box<T> {
    
//    Object container;
    T container;
    public Box(T cc){
    this.container =cc;
    }
    
    public T getValue(){
      return this.container;  
    }
    
    public static void main(String[] args) {
        Box<String> bb=new Box<String>("komal");
        System.out.println(bb.getValue());
     
    }
  
   //single abstract methods ->functional interface that is compatore         
   
}
