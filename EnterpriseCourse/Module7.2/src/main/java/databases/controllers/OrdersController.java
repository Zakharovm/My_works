package databases.controllers;

import databases.dao.DishDao;
import databases.dao.EmployeeDao;
import databases.dao.OrdersDao;
import databases.exceptions.ClosedOrderException;
import databases.model.Dish;
import databases.model.Orders;
import databases.model.Status;
import databases.model.Waiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);

    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrdersDao ordersDao;

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber, Date dateOfOrder) {
        Orders order = getOrder(waiterName, dishes, tableNumber, dateOfOrder);

        ordersDao.save(order);
    }

    @Transactional
    public void deleteOrder() {
        Orders order = ordersDao.findOrder(10);
        ordersDao.delete(order);
    }

    private Orders getOrder(String waiterName, List<String> dishes, int tableNumber, Date dateOfOrder) {
        Orders order = new Orders();
        order.setWaiter( (Waiter) employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setDateOfOrder(dateOfOrder);
        order.setCurrentStatus(Status.Open);
        return order;
    }

    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }

    @Transactional
    public void addDishes(List<String> dishes, int orderNumber) {
        LOGGER.info("Adding the dishes to the order. ");
        Orders order = ordersDao.findOrder(orderNumber);

        order.setCurrentStatus(Status.Open);
        if (Status.Open.equals(order.getCurrentStatus())) {

            List<Dish> existingDishes = order.getDishes();

            for (String dishName : dishes) {
                existingDishes.add(dishDao.findByName(dishName));
            }
            order.setDishes(existingDishes);

            ordersDao.editOrder(order);
        } else {
            try {
                throw new ClosedOrderException(orderNumber);
            } catch (ClosedOrderException e) {
                LOGGER.error("[Error]: Closed order is found. " + e.getOrderId() + " You cannot save the dish to the closed order.");
            }
        }
    }

    @Transactional
    public void deleteDishes(List<String> dishes, int orderNumber) {
        LOGGER.info("Delete the dish from the order. ");
        Orders order = ordersDao.findOrder(orderNumber);

        order.setCurrentStatus(Status.Open);
        if (Status.Open.equals(order.getCurrentStatus())) {

            List<Dish> existingDishes = order.getDishes();

            for (String dishName : dishes) {
                existingDishes.remove(dishDao.findByName(dishName));
            }
            order.setDishes(existingDishes);

            ordersDao.editOrder(order);
        } else {
            try {
                throw new ClosedOrderException(orderNumber);
            } catch (ClosedOrderException e) {
                LOGGER.error("[Error]: Closed order is found. " + e.getOrderId() + " You cannot save the dish to the closed order.");
            }
        }
    }

    @Transactional
    public void closeOrder(int orderId) {
        Orders order = ordersDao.findOrder(orderId);
        if (Status.Open.equals(order.getCurrentStatus())) {
            order.setCurrentStatus(Status.Closed);
            LOGGER.info("The order #" + orderId + " was closed. ");
        } else {
            try {
                throw new ClosedOrderException(orderId);
            } catch (ClosedOrderException e) {
                LOGGER.error("[Error]: This order has already been closed. ");
            }
        }
    }

    @Transactional
    public void printOrders() {
        getAllOrders().forEach(System.out::println);
    }

    @Transactional
    public List<Orders> getOpenOrders() {
        return ordersDao.getOrders(Status.Open);
    }

    @Transactional
    public List<Orders> getClosedOrders() {
        return ordersDao.getOrders(Status.Closed);
    }

    @Transactional
    public List<Orders> getAllOrders() {
        return ordersDao.getOrders();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }
}
