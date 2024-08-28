/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImpl;

import Dao.ProductDao;
import EmUtil.EmUtil;
import Exception.ProductException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Product;

public class ProductImpl implements ProductDao {

    @Override
    public boolean addProduct(Product p) throws ProductException {
        boolean ans=false;
        EntityManager em=EmUtil.provideEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        ans=true;
        em.getTransaction().commit();
        em.close();
        return ans;
    }

    @Override
    public boolean deleteProduct(int id) throws ProductException {
        boolean ans=false;
        EntityManager em=EmUtil.provideEntityManager();
        Product p=em.find(Product.class,id);
        if(p!=null){
           em.getTransaction().begin();
           em.remove(p);
           ans=true;
           em.getTransaction().commit();
           em.close();
        }else{
        throw new ProductException("Product not found");
        }
        return ans;
    }

    @Override
    public boolean updateProduct(Product p) throws ProductException {
  boolean ans = false;
    EntityManager em = EmUtil.provideEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        ans = true;
    } catch (Exception e) {
        em.getTransaction().rollback();
        throw new ProductException("Failed to update product");
    } finally {
        em.close();
    }
    return ans;    }

    @Override
    public List<Product> findAllProduct() throws ProductException {
            EntityManager em=EmUtil.provideEntityManager();

        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Product> cq=cb.createQuery(Product.class);
        Root<Product> rootentry =cq.from(Product.class);
        CriteriaQuery<Product> all=cq.select(rootentry);
        TypedQuery<Product> allquery=em.createQuery(all);
        return allquery.getResultList();
    }

    @Override
    public Product findSingleProduct(int id) throws ProductException {
        EntityManager em=EmUtil.provideEntityManager();
        Product p=em.find(Product.class,id);
        return p;
    }
    
}
