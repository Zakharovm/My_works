package databases.model;

import java.util.List;

public interface DishDao {
    void add(Dish dish);

    void delete(int id);

    List<Dish> find(String name);

    List<Dish> findAll();
}
