/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class Document implements Printable {
    private String text;
    public Document(String text){
    this.text=text;
    }
    @Override
    public void print(){
        System.out.println(" Document ");
        System.out.println(text);
    }
    
}
