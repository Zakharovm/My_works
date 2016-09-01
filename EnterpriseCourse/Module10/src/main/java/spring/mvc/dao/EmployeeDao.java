package spring.mvc.dao;

import spring.mvc.model.Employee;
import spring.mvc.model.Position;

import java.util.List;

public interface EmployeeDao {

        void save(Employee employee);

        void delete(Employee employee);

        Employee findByName(String name);

        Employee findBySurname(String surname);

        Employee findById(Integer id);

        Employee findByNameSurname(String name, String surname);

        List<Employee> findAll();

        List<Employee> getEmployeeByPosition(Position position);

}
