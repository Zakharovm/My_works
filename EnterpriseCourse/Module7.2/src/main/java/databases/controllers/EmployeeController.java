package databases.controllers;

import databases.dao.EmployeeDao;
import databases.model.Cook;
import databases.model.Employee;
import databases.model.Position;
import databases.model.Waiter;
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
        Cook employee = new Cook();
        employee.setSurname("Peskova");
        employee.setName("Lena");
        employee.setDateOfBirth("25-01-1965");
        employee.setPhoneNumber("053-123-42-53");
        employee.setPosition(Position.Cook);
        employee.setSalary(4000.0F);


        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);

        }

        Waiter employee1 = new Waiter();
        employee1.setSurname("Popova");
        employee1.setName("Vlada");
        employee1.setDateOfBirth("25-01-1965");
        employee1.setPhoneNumber("053-123-42-53");
        employee1.setPosition(Position.Waiter);
        employee1.setSalary(4000.0F);

        if (!allEmployees.contains(employee1)) {
            employeeDao.save(employee1);

        }

        Employee employee2 = new Employee();
        employee2.setSurname("Zakharov");
        employee2.setName("Maksym");
        employee2.setDateOfBirth("24-02-1994");
        employee2.setPhoneNumber("063-111-56-89");
        employee2.setPosition(Position.Administrator);
        employee2.setSalary(15000.0F);

        if (!allEmployees.contains(employee2)) {
            employeeDao.save(employee2);

        }

        Waiter employee3 = new Waiter();
        employee3.setSurname("Rubtsov");
        employee3.setName("Andrew");
        employee3.setDateOfBirth("20-06-1995");
        employee3.setPhoneNumber("063-111-56-90");
        employee3.setPosition(Position.Waiter);
        employee3.setSalary(5000.0F);

        if (!allEmployees.contains(employee3)) {
            employeeDao.save(employee3);

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
