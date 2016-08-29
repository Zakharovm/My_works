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
    public Employee getEmployeeByName(String employeeName) {
        return employeeDao.findByName(employeeName);
    }

    @Transactional
    public List<Employee> getAllWaiters(Position position) {
        return employeeDao.getEmployeeByPosition(position);
    }


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
