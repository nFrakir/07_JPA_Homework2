package com.gmail.silverleaf.annn.dbutilities;

import com.gmail.silverleaf.annn.dbobjects.Dish;

import java.util.List;

public class DishController {
    private DishDAO dishDAO;

    public DishController(DishDAO dishDAO) {
        super();
        this.dishDAO = dishDAO;
    }

    public DishController() {
        super();
    }

    public DishDAO getDishDAO() {
        return dishDAO;
    }

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }

    @Override
    public String toString() {
        return "DishController{" +
                "dishDAO=" + dishDAO +
                '}';
    }

    public List<Dish> getAllDishes() {
        return dishDAO.getAllDishes();
    }

    public List<Dish> getDishesByPrice(Double from, Double to) {
        return dishDAO.getDishesByPrice(from, to);
    }

    public List<Dish> getDishesByDiscount(Boolean is_discount) {
        return dishDAO.getDishesByDiscount(is_discount);
    }

    public List<Dish> getDishesByWeight() {
        return dishDAO.getDishesByWeight();
    }

    public void addDish(Dish dish) {
        dishDAO.addDish(dish);
    }
}
