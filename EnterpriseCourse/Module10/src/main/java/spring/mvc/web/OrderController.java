package spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.mvc.model.Orders;
import spring.mvc.model.Status;
import spring.mvc.service.OrderService;

import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Orders> order() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/order/{status}", method = RequestMethod.GET)
    public List<Orders> certainOrders(@PathVariable Status status) {
        return orderService.getAllCertainOrders(status);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Orders order(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
