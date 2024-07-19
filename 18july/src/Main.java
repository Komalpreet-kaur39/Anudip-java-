
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

public class Main {

  
    public static void main(String[] args) {
      
        ArrayList<String> lst=new ArrayList();
        lst.add("komal");
        lst.add("mehak");
        lst.add("muskan");
//      System.out.println(lst);
        
        ArrayList<String> lst1=new ArrayList();
        lst1.addAll(lst);
        lst1.add("komalpreet");
        lst1.add("mehakpreet");
        lst1.add("muskan saini");
//        System.out.println(lst1);
        
//to find the length
        System.out.println(lst1.size());
        
// to find the whether the element exit in the list or not//
        System.out.println(lst1.contains("komal"));
        
//to remove the particular object from the list
        System.out.println(lst1.remove(4));
        
        Iterator itr=lst1.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        
        
        
        System.out.println("-------------------------");
        System.out.println("Stack : ");
        Stack stk=new Stack();
        stk.push(12);
        stk.push(65);
        stk.push(23);
        stk.peek();
        stk.peek();
        stk.peek();
        System.out.println(stk);
        stk.pop();
        stk.pop();
        System.out.println(stk.peek());
        
        
        System.out.println("------------------------------");
        System.out.println("Hashset :");
        HashSet<String> hs=new HashSet<String>();
        hs.add("komal");
        hs.add("komal");
        hs.add("komal");
        hs.add("mehak");
        hs.add("muskan");
        hs.add("ekam");
        hs.add("manorma");
        hs.add("sannjot");
        hs.add(null);
        hs.add(null);
        System.out.println(hs);

            
        
        System.out.println("------------------------------");
        System.out.println("LinkedHashset :");
        LinkedHashSet<String> lh=new LinkedHashSet<String>();
        lh.add("komal");
        lh.add("komal");
        lh.add("komal");
        lh.add("mehak");
        lh.add("muskan");
        lh.add("ekam");
        lh.add("manorma");
        lh.add("sannjot");
        lh.add(null);
        lh.add(null);        
        System.out.println(lh);
        
        
        System.out.println("------------------------------");
        System.out.println("Treeset :");
        TreeSet<String> ts=new TreeSet<String>();
        ts.add("komal");
        ts.add("komal");
        ts.add("komal");
        ts.add("mehak");
        ts.add("muskan");
//        ts.add(null);
//        ts.add(null);
        System.out.println(ts);
        
//        TreeSet<String> th=new TreeSet<string>();
//        th.add("")
//        System.out.println(removeAll());
//hashset : no duplicate,single null,unorder
//linked hashser : no duplicate, insertion order,null values 
//treehashser no duplicate ,ascending order,no null
    }
    
}
