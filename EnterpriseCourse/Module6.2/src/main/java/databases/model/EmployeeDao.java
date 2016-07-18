package databases.model;

import java.util.List;

public interface EmployeeDao {

        void add(Employee employee);

        void delete(int id);

        List<Employee> find(String name);

        List<Employee> findAll();

}
