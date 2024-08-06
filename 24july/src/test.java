
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class test {
    public static void main(String[] args) {
        ArrayList<Employee> lst=new ArrayList();
        lst.add(new Employee(1,"kom",123));
        lst.add(new Employee(2,"komalpreet",1235));
        System.out.println("sorting by name :");
         Collections.sort(lst,new  nameComparator());
        
//        Collections.sort(lst,new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                 Employee e1=(Employee)o1;
//       
//       Employee e2=(Employee)o1;
//       
//       if(e1.id==e2.id){
//       return 0;
//       }else if(e1.id>e2.id){
//       return 1;
//       }else{
//       return -1;
//       }
//            }
//        });
       for (Employee e: lst){
           System.out.println(e);
       }
       

    }
    
}
