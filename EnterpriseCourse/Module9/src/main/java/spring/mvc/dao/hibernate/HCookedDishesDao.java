package spring.mvc.dao.hibernate;

import spring.mvc.dao.CookedDishesDao;
import spring.mvc.dao.StockDao;
import spring.mvc.model.CookedDishes;
import spring.mvc.model.Dish;
import spring.mvc.model.Ingredient;
import spring.mvc.model.Stock;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HCookedDishesDao implements CookedDishesDao {
    private SessionFactory sessionFactory;
    private StockDao stockDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(HCookedDishesDao.class);

    @Override
    @Transactional
    public void save(CookedDishes cookedDishes) {

        Dish dish = cookedDishes.getDish();
        Map<Ingredient, Float> dishComposition = dish.getComposition();
        List<Stock> listOfIngredientsStock = new ArrayList<>();
        final boolean[] ingredientsEnough = {true};

        dishComposition.forEach((ingredient, amount) -> {
            Stock stock = stockDao.findByName(ingredient.getName());
            Float quantityInStock = stock.getQuantity();
            if ( (quantityInStock >= amount) && ingredientsEnough[0])  {


                stock.setQuantity(quantityInStock - amount);

                listOfIngredientsStock.add(stock);
            } else {
                ingredientsEnough[0] = false;
            }

        });

        if (ingredientsEnough[0]) {
            for (Stock stock : listOfIngredientsStock) {
                stockDao.edit(stock);
            }

            LOGGER.info("Adding the cooked dish to the table. " + cookedDishes.toString());
            sessionFactory.getCurrentSession().save(cookedDishes);
        } else {
            LOGGER.error("Not enough ingredients on the stock to cook the dish: " + cookedDishes.toString());
        }

    }

    @Override
    @Transactional
    public List<CookedDishes> findAll() {
        LOGGER.info("Selecting the list of cooked dishes. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT cd FROM CookedDishes cd ORDER BY id").list();
    }

    @Override
    public CookedDishes findByName(String name) {
        LOGGER.info("Finding the cooked dish by specific name: " + name);
        return (CookedDishes) sessionFactory.getCurrentSession()
                .createQuery("SELECT cd FROM CookedDishes cd WHERE cd.name like :name")
                .setParameter("name", name)
                .uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }
}
