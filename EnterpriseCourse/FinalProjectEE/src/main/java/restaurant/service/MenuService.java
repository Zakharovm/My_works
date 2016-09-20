package restaurant.service;

import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.DishDao;
import restaurant.dao.MenuDao;
import restaurant.model.Category;
import restaurant.model.Dish;
import restaurant.model.Menu;
import restaurant.service.dao.MenuServiceDao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MenuService implements MenuServiceDao {
    private MenuDao menuDao;
    private DishDao dishDao;

    @Override
    @Transactional
    public Dish getDish(String dish) {
        return dishDao.findByName(dish);
    }

    @Override
    @Transactional
    public List<Menu> getAllMenus() {
        return menuDao.findAll();
    }

    @Override
    @Transactional
    public Menu getMenu(String name) {
        return menuDao.findByName(name);
    }

    @Override
    @Transactional
    public List<Dish> getDishesListInMenu(Integer id) {
        return menuDao.findById(id).getDishes();
    }

    @Override
    @Transactional
    public Set<Category> getAllCategories(Integer id) {
        Set<Category> categories = new TreeSet<>();
        List<Dish> dishes = menuDao.findById(id).getDishes();
        dishes.forEach(dish -> categories.add(dish.getCategory()));

        return categories;
    }

    @Override
    @Transactional
    public Menu findById(Integer id) {
        return menuDao.findById(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Menu menu) {
        menuDao.saveOrUpdate(menu);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        menuDao.delete(findById(id));
    }


    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
