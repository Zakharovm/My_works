package restaurant.service.dao;

import restaurant.model.Orders;
import restaurant.model.Status;

import java.util.Date;
import java.util.List;

public interface OrderServiceDao {
    List<Orders> getAllOrders();

    List<Orders> getAllCertainOrders(Status status);

    Orders findById(Integer id);

    List<Orders> dateFilter (Date date);

    List<Orders> waiterFilter (String name);

    List<Orders> tableFilter (Integer number);

}
