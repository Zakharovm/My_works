package databases.dao.hibernate;

import databases.dao.MenuDao;
import databases.model.Menu;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HMenuDao implements MenuDao {

    private SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(HMenuDao.class);

    @Override
    @Transactional
    public void save(Menu menu) {
        LOGGER.info("Adding the menu to the table. " + menu.toString());
        sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    @Transactional
    public void delete(Menu menu) {
        LOGGER.info("Delete the menu from the table. " + menu.toString());
        sessionFactory.getCurrentSession().delete(menu);
    }

    @Override
    @Transactional
    public void editMenu(Menu menu) {
        LOGGER.info("Editing the menu '" + menu.getName() + "'. ");
        sessionFactory.getCurrentSession().update(menu);
    }

    @Override
    @Transactional
    public Menu findByName(String name) {
        LOGGER.info("Finding the menu by specific name: " + name);
        return (Menu) sessionFactory.getCurrentSession()
                .createQuery("SELECT m FROM Menu m WHERE m.name like :name")
                .setParameter("name", name)
                .uniqueResult();
    }

    @Override
    @Transactional
    public List<Menu> findAll() {

        LOGGER.info("Selecting the list of Menu. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT m FROM Menu m ORDER BY id").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}