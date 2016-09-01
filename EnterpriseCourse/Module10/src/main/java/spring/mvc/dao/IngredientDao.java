package spring.mvc.dao;

import spring.mvc.model.Ingredient;

import java.util.List;

public interface IngredientDao {

    void save(Ingredient ingredient);

    void delete(Ingredient ingredient);

    Ingredient findByName(String name);

    List<Ingredient> findAll();

}
