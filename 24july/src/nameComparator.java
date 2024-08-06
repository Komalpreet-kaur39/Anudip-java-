
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class nameComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
         Employee e1=(Employee)o1;
       
       Employee e2=(Employee)o1;
       return e1.name.compareTo(e2.name);
    
    }}

