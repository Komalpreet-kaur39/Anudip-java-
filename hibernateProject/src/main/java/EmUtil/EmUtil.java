
package EmUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EmUtil {
    private static EntityManagerFactory emf;
    static{
       emf= Persistence.createEntityManagerFactory("user_role");
    }
    public static EntityManager provideEntityManager(){
        return emf.createEntityManager();
    }
    
}
