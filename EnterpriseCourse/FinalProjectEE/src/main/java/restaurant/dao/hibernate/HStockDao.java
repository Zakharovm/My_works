package restaurant.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.StockDao;
import restaurant.model.Ingredient;
import restaurant.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class HStockDao implements StockDao {

    private SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(HStockDao.class);

    @Override
    @Transactional
    public void saveOrUpdate(Stock stock) {
        LOGGER.info("Adding the ingredient to the stock. " + stock.toString());
        sessionFactory.getCurrentSession().saveOrUpdate(stock);

    }

    @Override
    @Transactional
    public void delete(Stock stock) {
        LOGGER.info("Delete the ingredient from the stock. " + stock.toString());
        sessionFactory.getCurrentSession().delete(stock);

    }

    @Override
    @Transactional
    public Stock findByIngredient(Ingredient ingredient) {
        LOGGER.info("Loading the ingredient at the stock of ingredient_id: ");
        Stock result = null;
        try {
            result = (Stock) sessionFactory.getCurrentSession().createQuery("SELECT s FROM Stock s WHERE s.ingredient = :ingredient").setParameter("ingredient", ingredient).uniqueResult();
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }

        return result;
    }

    @Override
    @Transactional
    public Stock findById(Integer id) {
        LOGGER.info("Selecting the element in the stock of ingredients by id. ");
        Stock result = null;
        try {
            result = (Stock) sessionFactory.getCurrentSession().createQuery("SELECT s FROM Stock s WHERE s.id = :id").setParameter("id", id).uniqueResult();
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }

        return result;
    }

    @Override
    @Transactional
    public List<Stock> findAll() {
        LOGGER.info("Selecting the list of ingredients. ");

        List<Stock> result;
        result = sessionFactory.getCurrentSession().createQuery("SELECT s FROM Stock s ORDER BY id").list();
        if (result == null) return new ArrayList<>();
        return result;
    }

    @Override
    @Transactional
    public List<Stock> findPaucity() {
        LOGGER.info("Selecting the list of ingredients that are almost ended ( < 20000.0). ");
        List<Stock> result;
        result = sessionFactory.getCurrentSession().createQuery("SELECT s FROM Stock s WHERE s.quantity < 20000.0  ORDER BY id").list();
        if (result == null) return new ArrayList<>();
        return result;

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
