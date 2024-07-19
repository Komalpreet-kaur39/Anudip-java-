/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interface3;

import java.awt.BorderLayout;

/**
 *
 * @author Maninder Singh
 */
public class Paypal implements PaymentMethod {
    String email;
    public Paypal(String email)
    {this.email=email;
}

    @Override
    public void pay(double amount){
    System.out.println("Paying :"+amount);
}


    @Override
    public void paypal() {
        System.out.println("Paypal "+email);
    }

  




}
