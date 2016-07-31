package databases.dao.hibernate;

import databases.dao.OrdersDao;
import databases.exceptions.ClosedOrderException;
import databases.model.Orders;
import databases.model.Status;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HOrdersDao implements OrdersDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(HOrdersDao.class);

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Orders orders) {
        LOGGER.info("Adding the order to the table. " + orders.toString());
        sessionFactory.getCurrentSession().save(orders);
    }

    @Override
    @Transactional
    public void delete(Orders orders) {


        if (Status.Open.equals(orders.getCurrentStatus())) {
            sessionFactory.getCurrentSession().delete(orders);
            LOGGER.info("Delete the order from the table. " + orders.toString());
        } else {
            try {
                throw new ClosedOrderException(orders.getId());
            } catch (ClosedOrderException e) {
                LOGGER.error("[Error]: Closed order is found. " + e.getOrderId() + " You cannot save the dish to the closed order.");
            }
        }

    }

    @Override
    @Transactional
    public Orders findOrder(int id) {
        LOGGER.info("Finding the order by id " + id);
        return (Orders) sessionFactory.getCurrentSession()
                .createQuery("SELECT o FROM Orders o WHERE o.id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    @Transactional
    public void editOrder(Orders orders) {
        LOGGER.info("Editing the order # " + orders.getId());
        sessionFactory.getCurrentSession().update(orders);
    }

    @Override
    @Transactional
    public List<Orders> getOrders(Status status) {
        LOGGER.info("Selecting the list of " + status + " orders. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Orders o ORDER BY id, WHERE o.currentStatus like :currentStatus").setParameter("currentStatus", status).list();
    }

    @Override
    @Transactional
    public List<Orders> getOrders() {
        LOGGER.info("Selecting the list of orders. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Orders o ORDER BY id").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
