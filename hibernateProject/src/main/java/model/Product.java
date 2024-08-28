/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Maninder Singh
 */
@Entity
@Table(name="Product")
public class Product {
    
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)      
     int productId;
    String productName;
    double productPrice;
    
    
    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product() {
    }

  
    public int getProductId() {
        return productId;
    }

    public void setProductId(int ProductId) {
        this.productId = ProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double ProductPrice) {
        this.productPrice = ProductPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductId=" + productId + ", productName=" + productName + ", ProductPrice=" + productPrice + '}';
    }
    
}       
