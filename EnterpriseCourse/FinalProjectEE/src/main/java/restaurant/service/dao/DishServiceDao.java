package restaurant.service.dao;

import restaurant.model.Category;
import restaurant.model.Dish;

import java.util.List;
import java.util.Set;

public interface DishServiceDao {
    void saveOrUpdate(Dish dish);

    void delete(Integer id);

    Dish findById(Integer id);

    Dish findByName(String dishName);

    Set<Category> getAllCategories();

    List<Dish> getAllDishes();

}
