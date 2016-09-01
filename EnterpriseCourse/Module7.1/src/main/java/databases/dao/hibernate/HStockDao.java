package databases.dao.hibernate;

import databases.dao.IngredientDao;
import databases.dao.StockDao;
import databases.model.Stock;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HStockDao implements StockDao {

    private SessionFactory sessionFactory;
    private IngredientDao ingredientDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(HStockDao.class);

    @Override
    @Transactional
    public void save(Stock stock) {
        LOGGER.info("Adding the ingredient to the stock. " + stock.toString());
        sessionFactory.getCurrentSession().save(stock);

    }

    @Override
    @Transactional
    public void delete(Stock stock) {
        LOGGER.info("Delete the ingredient from the stock. " + stock.toString());
        sessionFactory.getCurrentSession().delete(stock);

    }

    @Override
    @Transactional
    public void edit(Stock stock) {
        LOGGER.info("Update the ingredient information. " + stock.toString());
        sessionFactory.getCurrentSession().update(stock);
    }

    @Override
    @Transactional
    public Stock findByName(String name) {
        LOGGER.info("Finding the ingredient by specific name: " + name);
        List<Stock> ingredientsInStock = findAll();
        Stock stock = new Stock();
        for (Stock ingredient : ingredientsInStock) {
            if (ingredientDao.findByName(name).equals(ingredient.getIngredient())) {
                stock = ingredient;
                break;
            }
        }
        LOGGER.info("Found: " + stock.toString());
        return stock;
    }


    @Override
    @Transactional
    public List<Stock> findAll() {
        LOGGER.info("Selecting the list of ingredients. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT s FROM Stock s ORDER BY id").list();
    }

    @Override
    @Transactional
    public List<Stock> findPaucity() {
        LOGGER.info("Selecting the list of ingredients that are almost ended ( < 1000 grams). ");
        return sessionFactory.getCurrentSession().createQuery("SELECT s FROM Stock s WHERE s.quantity < 1000").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
