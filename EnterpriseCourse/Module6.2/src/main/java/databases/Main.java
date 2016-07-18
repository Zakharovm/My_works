package databases;

import databases.controllers.DishController;
import databases.controllers.EmployeeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;
    private DishController dishController;


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);


        main.start();

    }

    private void start() {
        employeeController.createEmployee();
        employeeController.deleteEmployee();
        employeeController.findEmployee().forEach(System.out::println);
        employeeController.getAllEmployees().forEach(System.out::println);

        dishController.createDish();
        dishController.deleteDish();
        dishController.findDish().forEach(System.out::println);
        dishController.getAllDishes().forEach(System.out::println);
    }



    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
