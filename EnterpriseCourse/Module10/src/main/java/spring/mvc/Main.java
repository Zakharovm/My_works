package spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.mvc.service.EmployeeService;
import spring.mvc.service.MenuService;
import spring.mvc.service.OrderService;

public class Main {

    private EmployeeService employeeService;
    private OrderService orderService;
    private MenuService menuService;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/application-context.xml", "WEB-INF/hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);

        main.start();


    }



    private void start() {
        employeeService.getEmployees().forEach(System.out::println);

        orderService.getAllOrders().forEach(System.out::println);

        menuService.getAllMenus().forEach(System.out::println);

    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;


    }
}
