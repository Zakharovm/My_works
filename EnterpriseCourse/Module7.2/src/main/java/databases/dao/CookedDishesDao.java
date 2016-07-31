package databases.dao;

import databases.model.CookedDishes;

import java.util.List;

public interface CookedDishesDao {

    void save(CookedDishes cookedDishes);

    List<CookedDishes> findAll();

    CookedDishes findByName(String name);
}
