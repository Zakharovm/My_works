package databases.controllers;

import databases.dao.EmployeeDao;
import databases.model.Employee;
import databases.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class EmployeeController {
    private EmployeeDao employeeDao;


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Transactional
    public void createEmployee() {
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());
        Employee employee = new Employee();
        employee.setSurname("Peskova");
        employee.setName("Lena");
        employee.setDateOfBirth("25-01-1965");
        employee.setPhoneNumber("053-123-42-53");
        employee.setPosition(Position.Cook);
        employee.setSalary(4000.0F);


        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);

        }

        Employee employee1 = new Employee();
        employee1.setSurname("Popova");
        employee1.setName("Vlada");
        employee1.setDateOfBirth("25-01-1965");
        employee1.setPhoneNumber("053-123-42-53");
        employee1.setPosition(Position.Waiter);
        employee1.setSalary(4000.0F);

        if (!allEmployees.contains(employee1)) {
            employeeDao.save(employee1);

        }


    }

    @Transactional
    public void deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee findEmployee() {
        return employeeDao.findByName("Vlada");
    }


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

}
