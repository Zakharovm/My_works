package restaurant.dao;


import restaurant.model.Orders;
import restaurant.model.Status;
import restaurant.model.Waiter;

import java.util.Date;
import java.util.List;

public interface OrdersDao {

    void save(Orders orders);

    void delete(Orders orders);

    Orders findOrder(Integer id);

    void editOrder(Orders orders);

    List<Orders> getOrders(Status status);

    List<Orders> getOrders();

    List<Orders> filterDate(Date date);

    List<Orders> filterWaiter(Waiter waiter);

    List<Orders> filterTableNumber(Integer number);

}
