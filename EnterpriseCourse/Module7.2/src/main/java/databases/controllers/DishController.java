package databases.controllers;

import databases.dao.DishDao;
import databases.model.Category;
import databases.model.Dish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DishController {

    private DishDao dishDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(DishController.class);

    @Transactional
    public void createDish() {
        Set<Dish> allDishes = new HashSet<>(dishDao.findAll());

        Dish dish = getDish("Napoleon", Category.Dessert, 50.0F, 300.0F);

        if (!allDishes.contains(dish)) {
            dishDao.save(dish);
        }

        Dish dish1 = getDish("Plov", Category.Garnish, 30.0F, 200.0F);

        if (!allDishes.contains(dish1)) {
            dishDao.save(dish1);
        }

    }

    private Dish getDish(String name, Category category, float price, float weight) {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setCategory(category);
        dish.setPrice(price);
        dish.setWeight(weight);
        return dish;
    }

    @Transactional
    public void deleteDish() {
        Dish dish = getDish("Napoleon", Category.Dessert, 50.0F, 300.0F);

        dishDao.delete(dish);
    }

    @Transactional
    public List<Dish> getAllDishes() {

       return dishDao.findAll();
    }

    @Transactional
    public Dish findDish() {
        return dishDao.findByName("Pork");
    }


    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
