package org.gvredonditos.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gvredonditos.model.Pais;


import java.util.List;

public class Main {
    public static void main(String[] args) {


        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("bonvino2");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            List<Pais> paises = em.createQuery("select p from Pais p", Pais.class).getResultList();
            paises.forEach(p -> System.out.println(p));

            em.getTransaction().commit();
            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bonvino");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//        List<Pais> paises = em.createQuery("select p from Pais p", Pais.class).getResultList();
//
//        paises.forEach(p -> System.out.println(p.toString()));

    }
}
