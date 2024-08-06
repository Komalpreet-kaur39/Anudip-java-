/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg5aug;

/**
 *
 * @author Maninder Singh
 */
public class Champu {
    private static Champu instance;
    
    private Champu(){
    
    }
    public static Champu getInstance() {
        if(instance == null) {
            instance = new Champu();
        }
        return instance;
    }
    public static void main(String[] args) {
        Champu c1=Champu.getInstance();
                Champu c2=Champu.getInstance();

        System.out.println(c1.hashCode());
                System.out.println(c2.hashCode());

    }
}
