package databases.controllers;

import databases.dao.DishDao;
import databases.dao.EmployeeDao;
import databases.dao.OrdersDao;
import databases.dao.PreparedDishesDao;
import databases.model.PreparedDishes;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class PreparedDishesController {

    private PreparedDishesDao preparedDishesDao;
    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrdersDao ordersDao;

    @Transactional
    public void addPreparedDish() {
        PreparedDishes dish = getDish("Aleksandr", "Napoleon", 12, new Date());
        preparedDishesDao.save(dish);

    }

    @Transactional
    public List<PreparedDishes> getAllPreparedDishes() {
        return preparedDishesDao.findAll();

    }


    private PreparedDishes getDish(String cookName, String dishName, int orderNumber, Date date) {
        PreparedDishes dish = new PreparedDishes();
        dish.setCook(employeeDao.findByName(cookName));
        dish.setDish(dishDao.findByName(dishName));
        dish.setOrder(ordersDao.findOrder(orderNumber));
        dish.setDate(date);
        return dish;
    }

    @Transactional
    public void printPreparedDishes() {
        getAllPreparedDishes().forEach(System.out::println);
    }

    public void setPreparedDishesDao(PreparedDishesDao preparedDishesDao) {
        this.preparedDishesDao = preparedDishesDao;
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
