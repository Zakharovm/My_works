package spring.mvc.dao.hibernate;

import spring.mvc.dao.DishCompositionDao;
import spring.mvc.dao.DishDao;
import spring.mvc.dao.IngredientDao;
import spring.mvc.model.Dish;
import spring.mvc.model.DishComposition;
import spring.mvc.model.Ingredient;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HDishCompositionDao implements DishCompositionDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(HDishCompositionDao.class);

    private SessionFactory sessionFactory;
    private DishDao dishDao;
    private IngredientDao ingredientDao;

    @Override
    @Transactional
    public void save(DishComposition dishComposition) {
        LOGGER.info("Adding the dish composition to table. " + dishComposition.toString());
        sessionFactory.getCurrentSession().save(dishComposition);
    }

    @Override
    @Transactional
    public void delete(DishComposition dishComposition) {
        LOGGER.info("Delete the dish composition from the table: " + dishComposition.toString());
        sessionFactory.getCurrentSession().delete(dishComposition);
    }

    @Override
    @Transactional
    public DishComposition findCompositionByDishNameAndIngredient(String dishName, String ingredientName) {
        LOGGER.info("Finding the dish composition for the specific dish: " + dishName);

        Dish dish = dishDao.findByName(dishName);
        Ingredient ingredient = ingredientDao.findByName(ingredientName);
        LOGGER.info("Finding the dish by specific dishName: " + dishName);
        return (DishComposition) sessionFactory.getCurrentSession()
                .createQuery("SELECT dc FROM DishComposition dc WHERE dc.dish = :dish AND dc.ingredient = :ingredient")
                .setParameter("dish", dish).setParameter("ingredient", ingredient)
                .uniqueResult();
    }

    @Override
    @Transactional
    public List<DishComposition> findAll() {
        LOGGER.info("Selecting the list of dish compositions. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT dc FROM DishComposition dc ORDER BY id").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
