package restaurant.dao;

import restaurant.model.Employee;
import restaurant.model.Position;
import restaurant.model.Waiter;

import java.util.List;

public interface EmployeeDao {

        void saveOrUpdate(Employee employee);

        void delete(Employee employee);

        Employee findByName(String name);

        Employee findBySurname(String surname);

        Employee findById(Integer id);

        Employee findByNameSurname(String name, String surname);

        List<Employee> findAll();

        List<Employee> getEmployeeByPosition(Position position);


}
