package databases.dao;

import databases.model.Employee;

import java.util.List;

public interface EmployeeDao {

        void save(Employee employee);

        void delete(Employee employee);

        Employee findByName(String name);

        List<Employee> findAll();

}
