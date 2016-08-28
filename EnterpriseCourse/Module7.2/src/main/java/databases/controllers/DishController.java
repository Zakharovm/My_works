package databases.controllers;

import databases.dao.DishDao;
import databases.dao.IngredientDao;
import databases.model.Category;
import databases.model.Dish;
import databases.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DishController {

    private DishDao dishDao;
    private IngredientDao ingredientDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(DishController.class);

    @Transactional
    public void createDish(String dishName, Map<String, Float> ingredientDoses) {

        Dish dish = getDish(dishName, Category.Side_Dish, 30.0F, 250.0F, ingredientDoses);

        dishDao.save(dish);
    }

    private Dish getDish(String dishName, Category category, Float price, Float weight, Map<String, Float> ingredientDoses) {
        Dish dish = new Dish();
        dish.setName(dishName);
        dish.setCategory(category);
        dish.setPrice(price);
        dish.setWeight(weight);
        dish.setComposition(createComposition(ingredientDoses));
        return dish;
    }

    private Map<Ingredient, Float> createComposition(Map<String, Float> ingredientDoses) {
        Map<Ingredient, Float> result = new HashMap<>();
        ingredientDoses.forEach( (key, value) -> {
            Ingredient ingredient = ingredientDao.findByName(key);
            result.put(ingredient, value);
        });

        return result;
    }


    @Transactional
    public void deleteDish(String name, Map<String, Float> ingredientDoses) {
        Dish dish = getDish(name, Category.Side_Dish, 30.0F, 250.0F, ingredientDoses);
        dish.setId(14);
        dishDao.delete(dish);
    }

    @Transactional
    public List<Dish> getAllDishes() {

        return dishDao.findAll();
    }

    @Transactional
    public Dish findDish() {
        return dishDao.findByName("Skewers of pork");
    }


    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }


}
