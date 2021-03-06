package spring.mvc.dao;

import spring.mvc.model.Ingredient;
import spring.mvc.model.Stock;

import java.util.List;

public interface StockDao {

    void save(Stock stock);

    void delete(Stock stock);

    void edit(Stock stock);

    Stock findByName(String name);

    List<Stock> findAll();

    List<Stock> findPaucity();

    Stock findByIngredient(Ingredient ingredient);
}
