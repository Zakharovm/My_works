package restaurant.service;

import org.springframework.transaction.annotation.Transactional;
import restaurant.dao.OrdersDao;
import restaurant.model.Orders;
import restaurant.model.Status;
import restaurant.service.dao.EmployeeServiceDao;
import restaurant.service.dao.OrderServiceDao;

import java.util.Date;
import java.util.List;

public class OrderService implements OrderServiceDao {
    private OrdersDao ordersDao;
    private EmployeeServiceDao employeeServiceDao;

    @Override
    @Transactional
    public List<Orders> getAllOrders() {
        return ordersDao.getOrders();
    }

    @Override
    @Transactional
    public List<Orders> getAllCertainOrders(Status status) {
        return ordersDao.getOrders(status);
    }

    @Override
    @Transactional
    public Orders findById(Integer id) {
        return ordersDao.findOrder(id);
    }

    @Override
    @Transactional
    public List<Orders> dateFilter(Date date) {
        return ordersDao.filterDate(date);
    }

    @Override
    @Transactional
    public List<Orders> waiterFilter(String name) {

        return ordersDao.filterWaiter(employeeServiceDao.findWaiterByName(name));
    }

    @Override
    @Transactional
    public List<Orders> tableFilter(Integer number) {
        return ordersDao.filterTableNumber(number);
    }

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public void setEmployeeServiceDao(EmployeeServiceDao employeeServiceDao) {
        this.employeeServiceDao = employeeServiceDao;
    }
}
