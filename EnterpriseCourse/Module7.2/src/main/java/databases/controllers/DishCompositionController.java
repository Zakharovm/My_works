package databases.controllers;

import databases.dao.DishCompositionDao;
import databases.dao.IngredientDao;
import databases.model.DishComposition;
import org.springframework.transaction.annotation.Transactional;

public class DishCompositionController {

    private DishCompositionDao dishCompositionDao;
    private IngredientDao ingredientDao;

    @Transactional
    public DishComposition findDishComposition() {
        return dishCompositionDao.findCompositionByDishNameAndIngredient("Plov", "Rice");
    }

    public void setDishCompositionDao(DishCompositionDao dishCompositionDao) {
        this.dishCompositionDao = dishCompositionDao;
    }
}
