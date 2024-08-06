

//there is array of string and you to have find frequecy of each word  
//[apple ,banana,  banana , orange , banana , apple, orange ]
//output 
//apple  - 2
//banana - 3 
//orange  - 2


import java.util.*;
public class q1 {
    public static void main(String[] args) {
        ArrayList<String> lst=new ArrayList<>();
        lst.add("apple");
        lst.add("banana");
        lst.add("banana");
        lst.add("orange");
        lst.add("banana");
        lst.add("apple");
        lst.add("orange");
//        String[] words={"apple","banana","banana","orange","apple"};
        HashMap<String,Integer> mp=new HashMap<>();
            for(String element :lst){
            if(mp.containsKey(element))
            {
                mp.put(element,mp.get(element)+1);
            }
             else{   
                 mp.put(element,1);
            }
//             mp.put(element,mp.getOrDefault(element,0)+1);   
            }
           for(Map.Entry<String,Integer>ee:mp.entrySet()){
          System.out.println(ee.getKey()+"--->"+ee.getValue());
      }
            

        }
     
    
}