/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg5aug;

/**
 *
 * @author Maninder Singh
 */
public class student {
    
    private int s_id;
     
    private String s_name;
    private int s_marks;
    
    public student(int s_id,String s_name,int s_marks){
    this.s_id=s_id;
    this.s_name=s_name;
    this.s_marks=s_marks;
    }
    
    public String getname(String s_name){
        return s_name;
    }
    public int getid(int s_id){
    return s_id;
    }
    public int getmarks(int s_marks){
    return s_marks;
    }
    
    public void setid(int s_id){
    this.s_id=s_id;
    }
    public void setname(String s_name){
    this.s_name=s_name;
    }
    public void setmarks(int s_marks){
    this.s_marks=s_marks;
    }  
}
