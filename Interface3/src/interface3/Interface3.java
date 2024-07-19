/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interface3;

/**
 *
 * @author Maninder Singh
 */
public class Interface3 {

   
    public static void main(String[] args) {
        // TODO code application logic here
    CreditCard ob=new CreditCard("2342","24/5");
    double amount1=4900;
    ob.pay(amount1);
    ob.paypal();
    
    Paypal ob1=new Paypal("koaml@gmial.com");
    ob1.pay(amount1);
    ob1.paypal();
    }
    
    
}
