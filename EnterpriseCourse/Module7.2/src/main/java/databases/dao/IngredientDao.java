package databases.dao;

import databases.model.Ingredient;

import java.util.List;

public interface IngredientDao {

    void save(Ingredient ingredient);

    void delete(Ingredient ingredient);

    Ingredient findByName(String name);

    List<Ingredient> findAll();

}
