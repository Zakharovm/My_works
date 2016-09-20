package restaurant.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.OrdersDao;
import restaurant.exceptions.ClosedOrderException;
import restaurant.model.Orders;
import restaurant.model.Status;
import restaurant.model.Waiter;

import java.util.ArrayList;
import java.util.Date;
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
                LOGGER.error("[Error]: Closed order is found. " + e.getOrderId() + " You cannot saveOrUpdate the dish to the closed order.");
            }
        }

    }

    @Override
    @Transactional
    public Orders findOrder(Integer id) {
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
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Orders o WHERE o.currentStatus like :currentStatus").setParameter("currentStatus", status).list();
    }

    @Override
    @Transactional
    public List<Orders> getOrders() {
        LOGGER.info("Selecting the list of orders. ");
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Orders o ORDER BY id").list();
    }

    @Override
    @Transactional
    public List<Orders> filterDate(Date date) {
        LOGGER.info("Filter orders by date. " + date);
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Orders o WHERE o.dateOfOrder = :date ORDER BY id").setParameter("date", date).list();
    }

    @Override
    @Transactional
    public List<Orders> filterWaiter(Waiter waiter) {
        LOGGER.info("Filter orders by waiter. " + waiter.getName());
       return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Orders o WHERE o.waiter = :waiter ORDER BY id").setParameter("waiter", waiter).list();    }

    @Override
    @Transactional
    public List<Orders> filterTableNumber(Integer number) {
        LOGGER.info("Filter orders by table number. " + number);

        List<Orders> result;
        result = sessionFactory.getCurrentSession().createQuery("SELECT o FROM Orders o WHERE o.tableNumber = :tableNumber ORDER BY id").setParameter("tableNumber", number).list();
        if (result == null) return new ArrayList<>();
         return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
