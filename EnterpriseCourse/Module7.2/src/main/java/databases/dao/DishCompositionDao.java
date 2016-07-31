package databases.dao;

import databases.model.DishComposition;

import java.util.List;

public interface DishCompositionDao {

    void save(DishComposition dishComposition);

    void delete(DishComposition dishComposition);

    DishComposition findCompositionByDishNameAndIngredient(String dishName, String ingredientName);

    List<DishComposition> findAll();
}
