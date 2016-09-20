package restaurant.service;


import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.IngredientDao;
import restaurant.dao.StockDao;
import restaurant.model.Ingredient;
import restaurant.model.Stock;
import restaurant.service.dao.StockServiceDao;

import java.util.List;

public class StockService implements StockServiceDao {

    private StockDao stockDao;
    private IngredientDao ingredientDao;

    @Override
    @Transactional
    public void saveOrUpdate(Stock stock) {
        stockDao.saveOrUpdate(stock);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        stockDao.delete(findById(id));
    }

    @Override
    @Transactional
    public List<Stock> getAllIngredients() {
        return stockDao.findAll();
    }

    @Override
    @Transactional
    public Stock findById(Integer id) {
        return stockDao.findById(id);
    }


    @Override
    @Transactional
    public Stock findByIngredientName(String name) {
        Ingredient ingredient = ingredientDao.findByName(name);
        if (ingredient == null) return null;
        return stockDao.findByIngredient(ingredient);
    }

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
