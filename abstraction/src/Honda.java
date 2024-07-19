/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class Honda  extends Bike{
    @Override
    public void run(){
        System.out.println("running safely");
    }
    public static void main(String[] args) {
        Honda ob=new Honda();
        ob.run();
        ob.bikeBody();
    }
    
}
