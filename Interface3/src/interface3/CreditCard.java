/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interface3;

/**
 *
 * @author Maninder Singh
 */
public class CreditCard implements PaymentMethod{
 String cardNumber;
 String expirationDate;
 
 
 public CreditCard(String cardNumber,String expirationDate){
 this.cardNumber=cardNumber;
 this.expirationDate=expirationDate;
 }
    @Override
    public void pay(double amount) {
        System.out.println("paying some aount"+amount);
        
    }

    @Override
    public void paypal() {
        System.out.println("Credit card number");
        System.out.println(cardNumber);
        System.out.println("Expiration details :");
        System.out.println(expirationDate);
                
    }
        
    
}
