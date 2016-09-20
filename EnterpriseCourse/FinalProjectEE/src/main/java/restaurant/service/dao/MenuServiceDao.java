package restaurant.service.dao;

import restaurant.model.Category;
import restaurant.model.Dish;
import restaurant.model.Menu;

import java.util.List;
import java.util.Set;

public interface MenuServiceDao {

    Dish getDish(String dish);

    List<Menu> getAllMenus();

    Menu getMenu(String name);

    List<Dish> getDishesListInMenu(Integer id);

    Set<Category> getAllCategories(Integer id);

    Menu findById(Integer id);

    void saveOrUpdate(Menu menu);

    void delete(Integer id);

}
