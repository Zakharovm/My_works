package restaurant.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.MenuDao;
import restaurant.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class HMenuDao implements MenuDao {

    private SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(HMenuDao.class);

    @Override
    @Transactional
    public void saveOrUpdate(Menu menu) {
        LOGGER.info("Adding the menu to the table. " + menu.toString());
        sessionFactory.getCurrentSession().saveOrUpdate(menu);
    }

    @Override
    @Transactional
    public void delete(Menu menu) {
        LOGGER.info("Delete the menu from the table. " + menu.toString());
        sessionFactory.getCurrentSession().delete(menu);
    }

    @Override
    @Transactional
    public Menu findByName(String name) {
        LOGGER.info("Finding the menu by specific name: " + name);
        Menu result = null;
        try {
            result = (Menu) sessionFactory.getCurrentSession()
                    .createQuery("SELECT m FROM Menu m WHERE m.name like :name")
                    .setParameter("name", name)
                    .uniqueResult();
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }

        return result;


    }

    @Override
    @Transactional
    public List<Menu> findAll() {

        LOGGER.info("Selecting the list of Menu. ");
        List<Menu> result;
        result = sessionFactory.getCurrentSession().createQuery("SELECT m FROM Menu m ORDER BY id").list();
        if (result == null) return new ArrayList<>();
        return result;
    }

    @Override
    @Transactional
    public Menu findById(Integer id) {
        LOGGER.info("Finding the menu by id " + id);
        Menu result = null;
        try {
            result = (Menu) sessionFactory.getCurrentSession()
                    .createQuery("SELECT m FROM Menu m WHERE m.id = :id")
                    .setParameter("id", id)
                    .uniqueResult();

        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Error finding the menu by id " + id);
        }

        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
