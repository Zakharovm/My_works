package restaurant.dao;

import restaurant.model.Ingredient;
import restaurant.model.Stock;

import java.util.List;

public interface StockDao {

    void saveOrUpdate(Stock stock);

    void delete(Stock stock);

    List<Stock> findAll();

    List<Stock> findPaucity();

    Stock findByIngredient(Ingredient ingredient);

    Stock findById(Integer id);
}
