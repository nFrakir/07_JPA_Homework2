package com.gmail.silverleaf.annn.dbutilities;

import com.gmail.silverleaf.annn.dbobjects.Dish;

import java.util.List;

public interface DishDAO {
    public List<Dish> getAllDishes();
    public List<Dish> getDishesByPrice(Double from, Double to);
    public List<Dish> getDishesByDiscount(Boolean is_discount);
    public List<Dish> getDishesByWeight();

    public void addDish(Dish dish);
}
