package databases.controllers;

import databases.model.Employee;
import databases.model.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;


public class EmployeeController extends JdbcDaoSupport {
    private EmployeeDao employeeDao;


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    public void createEmployee() {
        LOGGER.info("Create the parameters for the new employee. ");
        Employee employee = new Employee();
        employee.setId(15);
        employee.setSurname("Harchenko");
        employee.setName("Oleg");
        employee.setDateOfBirth("25-01-1965");
        employee.setPhoneNumber("053-123-42-53");
        employee.setPositionId(2);
        employee.setSalary(4000.0F);

        employeeDao.add(employee);

    }

    public void deleteEmployee() {
        employeeDao.delete(15);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public List<Employee> findEmployee() {
        return employeeDao.find("Maksym");
    }


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

}
