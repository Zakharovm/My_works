package spring.mvc.service;

import org.springframework.transaction.annotation.Transactional;
import spring.mvc.dao.EmployeeDao;
import spring.mvc.model.Employee;
import spring.mvc.model.Position;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeById(Integer id) {
        return employeeDao.findById(id);
    }

    @Transactional
    public Employee getEmployeeByName(String employeeName) {
        return employeeDao.findByName(employeeName);
    }

    @Transactional
    public Employee getEmployeeBySurname(String surname) {
        return employeeDao.findBySurname(surname);
    }

    @Transactional
    public Employee getEmployeeByNameSurname(String name, String surname) {
        return employeeDao.findByNameSurname(name, surname);
    }

    @Transactional
    public List<Employee> getAllWaiters(Position position) {
        return employeeDao.getEmployeeByPosition(position);
    }


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
