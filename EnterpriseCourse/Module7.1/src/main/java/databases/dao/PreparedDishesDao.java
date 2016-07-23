package databases.dao;

import databases.model.PreparedDishes;

import java.util.List;

public interface PreparedDishesDao {

    void save(PreparedDishes preparedDishes);

    List<PreparedDishes> findAll();
}
