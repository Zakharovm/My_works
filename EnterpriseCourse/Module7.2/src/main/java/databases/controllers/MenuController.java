package databases.controllers;

import databases.dao.DishDao;
import databases.dao.MenuDao;
import databases.model.Dish;
import databases.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private MenuDao menuDao;
    private DishDao dishDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @Transactional
    public void createMenu(String menuName, List<String> dishes) {
        Menu menu = getMenu(menuName, dishes);

        menuDao.save(menu);
    }

    @Transactional
    public void deleteMenu() {
        Menu menu = menuDao.findByName("Summer_dinner");
        menuDao.delete(menu);
    }

    private Menu getMenu(String name, List<String> dishes) {
        Menu menu = new Menu();
        menu.setName(name);
        menu.setDishes(createDishes(dishes));
        return menu;
    }

    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }

    @Transactional
    public void addDishes(List<String> dishes, String menuName) {
        LOGGER.info("Adding the dishes to the menu. ");
        Menu menu = menuDao.findByName(menuName);

            List<Dish> existingDishes = menu.getDishes();

            for (String dishName : dishes) {
                existingDishes.add(dishDao.findByName(dishName));
            }
            menu.setDishes(existingDishes);

            menuDao.editMenu(menu);
        }


    @Transactional
    public void deleteDishes(List<String> dishes, String menuName) {
        LOGGER.info("Delete the dishes from the menu. ");
        Menu menu = menuDao.findByName(menuName);

        List<Dish> existingDishes = menu.getDishes();

        for (String dishName : dishes) {
            existingDishes.remove(dishDao.findByName(dishName));
        }
        menu.setDishes(existingDishes);

        menuDao.editMenu(menu);
    }


    @Transactional
    public void printMenus() {
        getAllMenus().forEach(System.out::println);
    }

    @Transactional
    public List<Menu> getAllMenus() {
        return menuDao.findAll();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
