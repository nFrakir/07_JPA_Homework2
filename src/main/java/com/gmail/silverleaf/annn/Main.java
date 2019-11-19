package com.gmail.silverleaf.annn;

import com.gmail.silverleaf.annn.dbobjects.Dish;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Study");
        EntityManager em = emf.createEntityManager();

        //Query query = em.createQuery("select elements(c.id) from (select c from Dish c where sum(c.weight) <= 1)", Dish.class);
        //query.setParameter(1, is_discount);

        em.getTransaction().begin();
        Dish dish = new Dish("test", 0.1, 50.0, false);
        em.persist(dish);
        em.getTransaction().commit();

        Query query = em.createQuery("select c from Dish c", Dish.class);
        List<Dish> dishes = query.getResultList();

        for (Dish element: dishes) {
            System.out.println(element);
        }
    }
}
