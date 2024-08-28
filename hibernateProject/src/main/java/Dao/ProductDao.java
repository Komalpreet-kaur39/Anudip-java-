/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Exception.ProductException;
import java.util.List;
import model.Product;


public interface ProductDao {
    public boolean addProduct(Product p) throws ProductException;
    public boolean deleteProduct(int id) throws ProductException;
    public boolean updateProduct(Product p) throws ProductException;
     public List<Product> findAllProduct() throws ProductException;
     public Product findSingleProduct(int id) throws ProductException;
            
}
