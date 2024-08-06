import java.util.*;
public class TreeSetSorted {

    public static void main(String[] args) {
         // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a list of strings
        System.out.print("Enter a list of strings: ");
        
        // Read the entire line of input from the user
        String input = scanner.nextLine();
        
         // Create a TreeSet to store the strings in alphabetical order
        TreeSet<String> ts=new TreeSet<String>();
        
        // Split the input string into individual words based on spaces
        String words[]=input.split(" ");
        
         // Add each word to the TreeSet 
        for(String word:words){   
        ts.add(word);
        }
        // Print the elements of the TreeSet in alphabetical order
        System.out.println(ts); 
    }
    
}
