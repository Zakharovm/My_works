package databases;

import databases.controllers.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrdersController ordersController;
    private CookedDishesController cookedDishesController;
    private MenuController menuController;
    private StockController stockController;
    private DishCompositionController dishCompositionController;


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);

        main.start();


    }

    private void start() {
        System.out.println(dishCompositionController.findDishComposition().getAmount());

        employeeController.createEmployee();
        System.out.println(employeeController.findEmployee());
        employeeController.getAllEmployees().forEach(System.out::println);

        Map<String, Float> ingredients = new HashMap<>();
        ingredients.put("Pasta \"Italy\"", 200.0F);
        ingredients.put("Minced pork", 50.0F);

        dishController.createDish("Pasta nautically", ingredients);
        dishController.deleteDish("Pasta nautically", ingredients);
        System.out.println(dishController.findDish());
        dishController.getAllDishes().forEach(System.out::println);

        List<String> dishes = new ArrayList<>();
        dishes.add("Napoleon");
        dishes.add("Fries");
        dishes.add("Pasta");
        //ordersController.createOrder("Andrew", dishes, 4, new Date());


        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Cake");
        dishes1.add("Pork");

        //ordersController.addDishes(dishes1, 13);
        ordersController.deleteDishes(dishes1, 7);
        //ordersController.deleteOrder();
        ordersController.closeOrder(1);
        ordersController.closeOrder(3);
        ordersController.getAllOrders().forEach(System.out::println);

        cookedDishesController.addCookedDish();
        cookedDishesController.getAllCookedDishes().forEach(System.out::println);;

        List<String> dishes3 = new ArrayList<>();
        dishes3.add("Fries");
        dishes3.add("Pasta");
        menuController.createMenu("Summer_dinner", dishes3);
        menuController.deleteMenu();

        List<String> dishes4 = new ArrayList<>();
        dishes4.add("Cake");

        menuController.addDishes(dishes4, "Spring_morning");
        menuController.deleteDishes(dishes4, "Spring_morning");
        //menuController.deleteMenu();
        menuController.printMenus();

        stockController.addIngredient("Potato", 25000.0F);
        stockController.deleteIngredient("Potato");
        stockController.findIngredient("Cucumber");
        //stockController.changeQuantity("Cabbage", 50000.0F);
        stockController.printStock();


    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrdersController(OrdersController ordersController) {
        this.ordersController = ordersController;
    }

    public void setCookedDishesController(CookedDishesController cookedDishesController) {
        this.cookedDishesController = cookedDishesController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setStockController(StockController stockController) {
        this.stockController = stockController;
    }

    public void setDishCompositionController(DishCompositionController dishCompositionController) {
        this.dishCompositionController = dishCompositionController;
    }
}



