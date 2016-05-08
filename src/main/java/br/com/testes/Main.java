package br.com.testes;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author barizon
 */
public class Main {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabRufinoPU");
        emf.createEntityManager();
    }
}
