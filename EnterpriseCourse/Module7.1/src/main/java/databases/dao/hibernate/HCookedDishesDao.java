package databases.dao.hibernate;

import databases.dao.CookedDishesDao;
import databases.model.CookedDishes;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HCookedDishesDao implements CookedDishesDao {
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(HCookedDishesDao.class);

    @Override
    @Transactional
    public void save(CookedDishes cookedDishes) {
        LOGGER.info("Adding the prepared dish to the table. " + cookedDishes.toString());
        sessionFactory.getCurrentSession().save(cookedDishes);
    }

    @Override
    @Transactional
    public List<CookedDishes> findAll() {
        LOGGER.info("Selecting the list of prepared dishes. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT pd FROM PreparedDishes pd ORDER BY id").list();
    }

    @Override
    public CookedDishes findByName(String name) {
        LOGGER.info("Finding the prepared dish by specific name: " + name);
        return (CookedDishes) sessionFactory.getCurrentSession()
                .createQuery("SELECT pd FROM PreparedDishes pd WHERE pd.name like :name")
                .setParameter("name", name)
                .uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
