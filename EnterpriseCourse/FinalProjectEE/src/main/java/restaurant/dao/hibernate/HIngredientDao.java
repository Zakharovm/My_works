package restaurant.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.IngredientDao;
import restaurant.model.Ingredient;

import java.util.List;

public class HIngredientDao implements IngredientDao {

    private SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(HIngredientDao.class);

    @Override
    @Transactional
    public void saveOrUpdate(Ingredient ingredient) {
        LOGGER.info("Adding the ingredient to the table. " + ingredient.toString());
        sessionFactory.getCurrentSession().saveOrUpdate(ingredient);
    }

    @Override
    @Transactional
    public void delete(Ingredient ingredient) {
        LOGGER.info("Delete the ingredient from the table. " + ingredient.toString());
        sessionFactory.getCurrentSession().delete(ingredient);
    }

    @Override
    @Transactional
    public Ingredient findByName(String name) {
        LOGGER.info("Finding the ingredient by specific name: " + name);
        return (Ingredient) sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM Ingredient i WHERE i.name like :name")
                .setParameter("name", name)
                .uniqueResult();

    }

    @Override
    @Transactional
    public Ingredient findById(Integer id) {
        LOGGER.info("Finding the ingredient by specific id: " + id);
        return (Ingredient) sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM Ingredient i WHERE i.id = :id")
                .setParameter("id", id)
                .uniqueResult();

    }

    @Override
    @Transactional
    public List<Ingredient> findAll() {
        LOGGER.info("Selecting the list of ingredients. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT i FROM Ingredient i ORDER BY id").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
