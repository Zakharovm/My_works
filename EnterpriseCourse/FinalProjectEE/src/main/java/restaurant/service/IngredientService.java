package restaurant.service;

import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.IngredientDao;
import restaurant.model.Ingredient;
import restaurant.service.dao.IngredientServiceDao;

import java.util.List;

public class IngredientService implements IngredientServiceDao {

    private IngredientDao ingredientDao;

    @Override
    @Transactional
    public void saveOrUpdate(Ingredient ingredient) {
        ingredientDao.saveOrUpdate(ingredient);
    }

    @Override
    @Transactional
    public Ingredient findByName(String name) {
        return ingredientDao.findByName(name);
    }

    @Override
    @Transactional
    public List<Ingredient> getAllIngredients() {
        return ingredientDao.findAll();
    }

    @Override
    @Transactional
    public Ingredient findById(Integer id) {
        return ingredientDao.findById(id);
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
