package restaurant.dao;

import restaurant.model.Dish;

import java.util.List;

public interface DishDao {

    void saveOrUpdate(Dish dish);

    void delete(Dish dish);

    Dish findByName(String name);

    Dish findById(Integer id);

    List<Dish> findAll();
}
