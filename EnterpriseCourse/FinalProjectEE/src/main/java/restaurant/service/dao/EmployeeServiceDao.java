package restaurant.service.dao;

import restaurant.model.Employee;
import restaurant.model.Position;
import restaurant.model.Waiter;

import java.util.List;
import java.util.Set;

public interface EmployeeServiceDao {

    void saveOrUpdate(Employee employee);

    void delete(Integer id);

    Employee findById(Integer id);

    Employee findByName(String employeeName);

    Employee findBySurname(String surname);

    Employee findByNameSurname(String name, String surname);

    Set<Position> getAllPositions();

    List<Employee> getAllEmployees();

    List<Employee> findAllWaiters();

    Waiter findWaiterByName(String name);


}
