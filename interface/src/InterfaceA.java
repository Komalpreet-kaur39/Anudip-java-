/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */

public interface InterfaceA {
    default void method() {
        System.out.println("Default method in InterfaceA");
    }
}



public class ImplementingClass implements InterfaceA, InterfaceB {
    @Override
    public void method() {
        System.out.println("Overridden method to resolve conflict");
    }

    
}
