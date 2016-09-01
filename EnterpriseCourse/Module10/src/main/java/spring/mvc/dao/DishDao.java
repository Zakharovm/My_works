package spring.mvc.dao;

import spring.mvc.model.Dish;

import java.util.List;

public interface DishDao {

    void save(Dish dish);

    void delete(Dish dish);

    Dish findByName(String name);

    List<Dish> findAll();
}
