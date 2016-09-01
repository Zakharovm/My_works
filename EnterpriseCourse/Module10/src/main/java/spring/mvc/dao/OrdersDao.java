package spring.mvc.dao;


import spring.mvc.model.Orders;
import spring.mvc.model.Status;

import java.util.List;

public interface OrdersDao {

    void save(Orders orders);

    void delete(Orders orders);

    Orders findOrder(int id);

    void editOrder(Orders orders);

    List<Orders> getOrders(Status status);

    List<Orders> getOrders();

}
