package databases.dao.hibernate;

import databases.dao.DishDao;
import databases.model.Dish;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class HDishDao implements DishDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(HDishDao.class);

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Dish dish) {
        LOGGER.info("Adding the dish to table. " + dish.toString());
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    @Transactional
    public void delete(Dish dish) {
        LOGGER.info("Delete the dish from the table: " + dish.toString());
        sessionFactory.getCurrentSession().delete(dish);
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        LOGGER.info("Finding the dish by specific name: " + name);
        return (Dish) sessionFactory.getCurrentSession()
                .createQuery("SELECT d FROM Dish d WHERE d.name like :name")
                .setParameter("name", name)
                .uniqueResult();
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        List<Dish> dishList;
        LOGGER.info("Selecting the dish list. ");
        dishList = sessionFactory.getCurrentSession().createQuery("SELECT d FROM Dish d").list();

        return dishList;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
