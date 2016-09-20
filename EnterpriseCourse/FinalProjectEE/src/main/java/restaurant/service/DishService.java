package restaurant.service;

import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.DishDao;
import restaurant.model.Category;
import restaurant.model.Dish;
import restaurant.service.dao.DishServiceDao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DishService implements DishServiceDao {

    private DishDao dishDao;

    @Override
    @Transactional
    public void saveOrUpdate(Dish dish) {
        dishDao.saveOrUpdate(dish);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        dishDao.delete(findById(id));
    }

    @Override
    @Transactional
    public Dish findById(Integer id) {
        return dishDao.findById(id);
    }

    @Override
    @Transactional
    public Dish findByName(String dishName) {
        return dishDao.findByName(dishName);
    }

    @Override
    @Transactional
    public Set<Category> getAllCategories() {
        Set<Category> categories = new TreeSet<>();
        List<Dish> dishes = dishDao.findAll();
        dishes.forEach(dish -> categories.add(dish.getCategory()));

        return categories;
    }

    @Override
    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
