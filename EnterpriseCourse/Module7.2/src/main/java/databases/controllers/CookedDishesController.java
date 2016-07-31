package databases.controllers;

import databases.dao.DishDao;
import databases.dao.EmployeeDao;
import databases.dao.OrdersDao;
import databases.dao.CookedDishesDao;
import databases.model.Cook;
import databases.model.CookedDishes;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class CookedDishesController {

    private CookedDishesDao cookedDishesDao;
    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrdersDao ordersDao;

    @Transactional
    public void addCookedDish() {
        CookedDishes cookedDish = getDish("Lena", "Napoleon", 12, new Date());

        cookedDishesDao.save(cookedDish);

    }

    @Transactional
    public List<CookedDishes> getAllCookedDishes() {
        return cookedDishesDao.findAll();

    }


    private CookedDishes getDish(String cookName, String dishName, int orderNumber, Date date) {
        CookedDishes dish = new CookedDishes();
        dish.setCook( (Cook) employeeDao.findByName(cookName));
        dish.setDish(dishDao.findByName(dishName));
        dish.setOrder(ordersDao.findOrder(orderNumber));
        dish.setDate(date);
        return dish;
    }

    @Transactional
    public void printPreparedDishes() {
        getAllCookedDishes().forEach(System.out::println);
    }

    public void setCookedDishesDao(CookedDishesDao cookedDishesDao) {
        this.cookedDishesDao = cookedDishesDao;
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
