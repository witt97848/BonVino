package org.gvredonditos.context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbContext {
    private static DbContext instance = null;
    private EntityManager em;

    private DbContext() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bonvino_pu");
        em = emf.createEntityManager();
    }

    public static DbContext getInstance() {
        if (instance == null) {
            instance = new DbContext();
        }
        return instance;
    }

    public EntityManager getEntityManager() { return em;}
}
