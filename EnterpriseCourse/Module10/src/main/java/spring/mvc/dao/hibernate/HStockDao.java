package spring.mvc.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.dao.IngredientDao;
import spring.mvc.dao.StockDao;
import spring.mvc.model.Ingredient;
import spring.mvc.model.Stock;

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
    public Stock findByIngredient(Ingredient ingredient) {
        LOGGER.info("Loading the ingredient at the stock of ingredient_id: ");
        return (Stock) sessionFactory.getCurrentSession().createQuery("SELECT s FROM Stock s WHERE s.ingredient = :ingredient").setParameter("ingredient", ingredient).uniqueResult();
    }

    @Override
    @Transactional
    public Stock findByName(String name) {
        LOGGER.info("Finding the ingredient by specific name in the stock: " + name);
        Ingredient ingredient = ingredientDao.findByName(name);
        Stock result = findByIngredient(ingredient);
        LOGGER.info("Found: " + result.toString());
        return result;
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
        LOGGER.info("Selecting the list of ingredients that are almost ended ( < 20000.0). ");
        return sessionFactory.getCurrentSession().createQuery("SELECT s FROM Stock s WHERE s.quantity < 20000.0  ORDER BY id").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
