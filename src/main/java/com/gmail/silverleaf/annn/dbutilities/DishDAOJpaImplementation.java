package com.gmail.silverleaf.annn.dbutilities;

import com.gmail.silverleaf.annn.dbobjects.Dish;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DishDAOJpaImplementation implements DishDAO {
    private static final String GET_ALL_DISHES = "select c from Dish c";
    private static final String GET_DISHES_BY_PRICE = "select c from Dish c where c.price between ?1 and ?2";
    private static final String GET_DISHES_BY_DISCOUNT = "select c from Dish c where c.is_discount = ?1";

    @Override
    public List<Dish> getAllDishes() {
        Query query = prepareQuery(GET_ALL_DISHES);
        return query.getResultList();
    }

    @Override
    public List<Dish> getDishesByPrice(Double from, Double to) {
        Query query = prepareQuery(GET_DISHES_BY_PRICE);
        query.setParameter(1, from);
        query.setParameter(2, to);
        return query.getResultList();
    }

    @Override
    public List<Dish> getDishesByDiscount(Boolean is_discount) {
        Query query = prepareQuery(GET_DISHES_BY_DISCOUNT);
        query.setParameter(1, is_discount);
        return query.getResultList();
    }

    @Override
    public List<Dish> getDishesByWeight() {
        Query query = prepareQuery(GET_ALL_DISHES);
        List<Dish> dishes = query.getResultList();
        List<Dish> filtered = new ArrayList<>();
        Double total = 0.0;
        for (Dish element : dishes) {
            total += element.getWeigth();
            if (total < 1.0) {
                filtered.add(element);
            } else {
                break;
            }
        }
        return filtered;
    }

    @Override
    public void addDish(Dish dish) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Study");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(dish);
        em.getTransaction().commit();
    }

    private Query prepareQuery(String queryString) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Study");
        EntityManager em = emf.createEntityManager();
        return em.createQuery(queryString, Dish.class);
    }
}
