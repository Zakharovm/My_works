package databases.dao.hibernate;

import databases.dao.PreparedDishesDao;
import databases.model.PreparedDishes;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HPreparedDishesDao implements PreparedDishesDao {
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(HPreparedDishesDao.class);

    @Override
    @Transactional
    public void save(PreparedDishes preparedDishes) {
        LOGGER.info("Adding the prepared dish to the table. " + preparedDishes.toString());
        sessionFactory.getCurrentSession().save(preparedDishes);
    }

    @Override
    @Transactional
    public List<PreparedDishes> findAll() {
        LOGGER.info("Selecting the list of prepared dishes. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT pd FROM PreparedDishes pd ORDER BY id").list();
    }

    @Override
    public PreparedDishes findByName(String name) {
        LOGGER.info("Finding the prepared dish by specific name: " + name);
        return (PreparedDishes) sessionFactory.getCurrentSession()
                .createQuery("SELECT pd FROM PreparedDishes pd WHERE pd.name like :name")
                .setParameter("name", name)
                .uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
