
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class Main {


    public static void main(String[] args) {
        TreeMap<String,Integer>mpp=new TreeMap<>();
      HashMap<String,Integer> mp=new HashMap<>();
      mp.put("komal",9);
      mp.put("mehak",8);
      mp.put("manorma",7);
      mp.put("karin",10);
//      mp.put(null,7);
//      mp.put(null,null);
      mp.put("yad",null);
      mp.put("kom",null);
      mpp.putAll(mp);
          
      for(Map.Entry<String,Integer>ee:mp.entrySet()){
          System.out.println(ee.getKey()+"--->"+ee.getValue());
      }
        System.out.println("--------------------------");
      for(Map.Entry<String,Integer>ee:mpp.entrySet()){
                System.out.println(ee.getKey()+"--->"+ee.getValue());

      }
    }
    
}
//can store more than one null value 
//the  new vALUE WILL override the last one
//does not follow insertion order