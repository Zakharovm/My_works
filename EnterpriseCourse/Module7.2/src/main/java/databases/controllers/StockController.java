package databases.controllers;

import databases.dao.IngredientDao;
import databases.dao.StockDao;
import databases.model.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StockController {

    private IngredientDao ingredientDao;
    private StockDao stockDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);

    @Transactional
    public void addIngredient(String ingredientName, Float quantity) {
        Stock stock = getIngredientForStock(ingredientName, quantity);

        stockDao.save(stock);
    }

    @Transactional
    public void deleteIngredient(String ingredientName) {
        Stock stock = stockDao.findByName(ingredientName);

        stockDao.delete(stock);

    }

    private Stock getIngredientForStock(String name, Float quantity) {
        Stock stock = new Stock();
        stock.setIngredient(ingredientDao.findByName(name));
        stock.setQuantity(quantity);
        return stock;
    }

    @Transactional
    public void changeQuantity(String ingredientName, Float newQuantity) {
        Stock stock = stockDao.findByName(ingredientName);
        stock.setQuantity(newQuantity);
        LOGGER.info("The quantity of " + stock.getIngredient() + " was changed to " + newQuantity);
        stockDao.edit(stock);

    }

    @Transactional
    public void findIngredient(String name) {
        stockDao.findByName(name);
    }

    @Transactional
    public void printStock() {
        getAllIngredientsInStock().forEach(System.out::println);
        getAllPaucityIngredientsInStock().forEach(System.out::println);
    }

    @Transactional
    public List<Stock> getAllIngredientsInStock() {
        return stockDao.findAll();
    }

    @Transactional
    public List<Stock> getAllPaucityIngredientsInStock() {
        return stockDao.findPaucity();
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }
}
