
import java.util.ArrayList;
import java.util.Collections;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class Student implements Comparable<Student> {
    int rollno;
    String name;
    Student(String name,int rollno){
        super();
    this.name=name;
    this.rollno=rollno;
    }

    @Override
    public int compareTo(Student o) {
       if(rollno==o.rollno){
           return 0;
       
      }
       else if(rollno>o.rollno){
        return 1;
    }
       else {
       return -1;
       }
    }
    
    @Override
    public String toString(){
    return rollno+" "+name;
    }
    public static void main(String[] args) {
        ArrayList<Student> arr=new ArrayList<>();
        arr.add(new Student("yad", 13));
        arr.add(new Student("komal", 12));
        Collections.sort(arr);
        for(Student s:arr){
            System.out.println(s);
        }
        
            

    }

            
    
}
