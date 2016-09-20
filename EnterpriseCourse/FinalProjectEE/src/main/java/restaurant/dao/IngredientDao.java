package restaurant.dao;

import restaurant.model.Ingredient;

import java.util.List;

public interface IngredientDao {

    void saveOrUpdate(Ingredient ingredient);

    void delete(Ingredient ingredient);

    Ingredient findByName(String name);

    Ingredient findById(Integer id);

    List<Ingredient> findAll();

}
