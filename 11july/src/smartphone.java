/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class smartphone extends device{
    
    String operatingSystem;
    String  cameraResolution;
    public smartphone(String brand, String model, String operatingSystem, String cameraResolution) {
        super(brand, model);
        this.operatingSystem=operatingSystem;
        this.cameraResolution=cameraResolution;
    }
    
    public void displayInformation(){
     deviceInformation();
        System.out.println("The Operating system of the smartphone is "+operatingSystem);
        System.out.println("The Camera Resolution of the Smartphone is "+cameraResolution);
    }
    
    public void takePhoto(){
        System.out.println("The camera is taking photo with "+cameraResolution+"px");
    }
    
    
}
