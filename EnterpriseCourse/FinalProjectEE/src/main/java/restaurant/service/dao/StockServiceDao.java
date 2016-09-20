package restaurant.service.dao;

import restaurant.model.Stock;

import java.util.List;

public interface StockServiceDao {

    void saveOrUpdate(Stock stock);

    void delete(Integer id);

    Stock findById(Integer id);

    Stock findByIngredientName(String name);

    List<Stock> getAllIngredients();
}
