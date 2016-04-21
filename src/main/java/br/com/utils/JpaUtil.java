package br.com.utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author barizon
 */
public class JpaUtil {
    
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("trabRufinoPU");
    
    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void close(@Disposes EntityManager manager) {
        manager.close();
    }
}
