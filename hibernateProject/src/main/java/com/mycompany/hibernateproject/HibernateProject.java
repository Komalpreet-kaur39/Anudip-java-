/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hibernateproject;

import Dao.ProductDao;
import DaoImpl.ProductImpl;
import model.Product;

/**
 *
 * @author Maninder Singh
 */
public class HibernateProject {

    public static void main(String[] args) {

        ProductDao dao=new ProductImpl();
        Product p1= new Product();
//        p1.setProductId(3);
        p1.setProductName("book");
        p1.setProductPrice(400);
        boolean ans=dao.addProduct(p1);
        System.out.println(ans);
    }
}
