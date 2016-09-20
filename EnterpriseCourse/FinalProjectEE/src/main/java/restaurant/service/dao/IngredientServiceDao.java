package restaurant.service.dao;

import restaurant.model.Ingredient;

import java.util.List;

public interface IngredientServiceDao {

    void saveOrUpdate(Ingredient ingredient);

    List<Ingredient> getAllIngredients();

    Ingredient findByName(String name);

    Ingredient findById(Integer id);

}
