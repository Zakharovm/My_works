package spring.mvc.service;

import org.springframework.transaction.annotation.Transactional;
import spring.mvc.dao.DishDao;
import spring.mvc.dao.MenuDao;
import spring.mvc.model.Dish;
import spring.mvc.model.Menu;

import java.util.List;

public class MenuService {
    private MenuDao menuDao;
    private DishDao dishDao;

    @Transactional
    public List<Dish> getAllDishesInMenu(String menuName) {
        return menuDao.findAllDishes(menuName);
    }

    @Transactional
    public Dish getDish(String dish) {
        return dishDao.findByName(dish);
    }

    @Transactional
    public List<Menu> getAllMenus() {
        return menuDao.findAll();
    }

    @Transactional
    public Menu getMenu(String name) {
        return menuDao.findByName(name);
    }

    @Transactional
    public List<Dish> getDishesListInMenu(Integer id) {
        return menuDao.findById(id).getDishes();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
