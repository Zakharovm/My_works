package databases.controllers;

import databases.model.Dish;
import databases.model.DishDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DishController extends JdbcDaoSupport {

    private DishDao dishDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    public void createDish() {
        LOGGER.info("Create the parameters for the new dish. ");
        Dish dish = new Dish();
        dish.setId(30);
        dish.setName("Napoleon");
        dish.setCategory("Dessert");
        dish.setPrice(50.0F);
        dish.setWeight(300.0F);

        dishDao.add(dish);

    }

    public void deleteDish() {
        dishDao.delete(30);
    }

    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    public List<Dish> findDish() {
        return dishDao.find("Pork");
    }


    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
