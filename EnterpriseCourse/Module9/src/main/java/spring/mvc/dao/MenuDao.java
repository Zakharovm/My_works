package spring.mvc.dao;

import spring.mvc.model.Dish;
import spring.mvc.model.Menu;

import java.util.List;

public interface MenuDao {

    void save(Menu menu);

    void delete(Menu menu);

    void editMenu(Menu menu);

    Menu findByName(String name);

    List<Menu> findAll();

    List<Dish> findAllDishes(String menuName);
}
