package spring.mvc.service;

import org.springframework.transaction.annotation.Transactional;
import spring.mvc.dao.OrdersDao;
import spring.mvc.model.Orders;
import spring.mvc.model.Status;

import java.util.List;

public class OrderService {
    private OrdersDao ordersDao;

    @Transactional
    public List<Orders> getAllOrders() {
        return ordersDao.getOrders();
    }

    @Transactional
    public List<Orders> getAllCertainOrders(Status status) {
        return ordersDao.getOrders(status);
    }

    @Transactional
    public Orders getOrder(int id) {
        return ordersDao.findOrder(id);
    }

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }
}
