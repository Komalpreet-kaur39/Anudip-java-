/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maninder Singh
 */
public class Image  implements Printable{

    private int width,height;
    public Image(int width,int height){
    this.width=width;
    this.height=height;
    }
    @Override
    public void print() {
        System.out.println("dimensions of Image : ");
        System.out.println("width:"+width+"height :"+height);        
    }
    
}
